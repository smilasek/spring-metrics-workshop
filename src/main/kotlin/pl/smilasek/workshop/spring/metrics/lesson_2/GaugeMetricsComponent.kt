package pl.smilasek.workshop.spring.metrics.lesson_2

import io.micrometer.core.instrument.Gauge
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicInteger
import kotlin.random.Random.Default.nextInt

@Suppress("unused")
@Component
@EnableScheduling
class GaugeMetricsComponent(
        meterRegistry: MeterRegistry
) {
    private val atomicInteger = AtomicInteger(0)
    private val cache = mutableSetOf<Int>()

    private val gauge: Gauge = Gauge
            .builder("gauge.memory.utilization") { atomicInteger.get() }
            .register(meterRegistry)
    private val cacheGauge: Gauge = Gauge
            .builder("gauge.cache.size") { cache.size }
            .register(meterRegistry)

    @Scheduled(fixedDelay = 500)
    fun updateGauge() {
        atomicInteger.set(nextInt(1, 100))
    }

    @Scheduled(fixedDelay = 500)
    fun updateCache() {
        cache.add(nextInt(0, 100))
        if (cache.size > 40) cache.clear()
    }
}