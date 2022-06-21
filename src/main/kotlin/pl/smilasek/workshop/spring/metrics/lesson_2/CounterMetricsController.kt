package pl.smilasek.workshop.spring.metrics.lesson_2

import io.micrometer.core.annotation.Counted
import io.micrometer.core.aop.CountedAspect
import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Metrics
import org.springframework.context.annotation.Import
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Import(CountedAspect::class)
@RestController
class CounterMetricsController(
        private val meterRegistry: MeterRegistry
) {

    private val counter1 = meterRegistry.counter("counter.1")
    private val counter2 = Metrics.counter("counter.2")
    private val counter3 = counterWithDescription("counter.3")

    @Counted(value = "counter.aspect", description = "Some counter based on aspect")
    @GetMapping("/counter")
    fun incrementCounters(): String {
        counter1.increment()
        counter2.increment(2.0)
        counter3.increment()
        return "incremented";
    }

    private fun counterWithDescription(name: String) = Counter.builder(name)
            .description("Some counter based on meterRegistry")
            .baseUnit("times")
            .register(meterRegistry)

}