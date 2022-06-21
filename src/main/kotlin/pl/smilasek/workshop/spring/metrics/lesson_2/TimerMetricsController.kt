package pl.smilasek.workshop.spring.metrics.lesson_2

import io.micrometer.core.annotation.Timed
import io.micrometer.core.aop.TimedAspect
import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Metrics
import org.springframework.context.annotation.Import
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.TimeUnit.SECONDS
import kotlin.random.Random

@RestController
@Import(TimedAspect::class)
class TimerMetricsController(
        private val meterRegistry: MeterRegistry,
        private val someComponent: SomeComponent
) {
    private val timer1 = Metrics.timer("timer.1")
    private val timer2 = Metrics.timer("timer.2")

    @GetMapping("/timer")
    @Timed(value = "timer.aspect")
    fun measureTime(): String {
        timer1.record { executeSomeMethod(); someComponent.executeSomething() }
        timer2.record(10, SECONDS)
        return "measured time"
    }

    @Timed(value = "timer.aspect.some-internal-method")
    private fun executeSomeMethod() = sleepRandomSeconds()

}

@Component
class SomeComponent {

    @Timed("timer.aspect.some-component-method")
    fun executeSomething() = sleepRandomSeconds()
}

private fun sleepRandomSeconds() = Thread.sleep(Random.nextLong(0, 2) * 1000)