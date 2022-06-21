package pl.smilasek.workshop.spring.metrics.lesson_2

import io.micrometer.core.annotation.Timed
import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Metrics
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.TimeUnit.SECONDS
import kotlin.random.Random

@RestController
class TimerMetricsController(
        private val meterRegistry: MeterRegistry
) {
    private val timer1 = Metrics.timer("timer.1")
    private val timer2 = Metrics.timer("timer.2")

    @GetMapping("/timer")
    @Timed(value = "timer.aspect")
    fun measureTime(): String {
        timer1.record { executeSomeMethod() }
        timer2.record(10, SECONDS)
        return "measured time"
    }

    @Timed(value = "timer.aspect.some-method")
    private fun executeSomeMethod() = sleepRandomSeconds()

    private fun sleepRandomSeconds() = Thread.sleep(Random.nextLong(0, 2) * 1000)
}