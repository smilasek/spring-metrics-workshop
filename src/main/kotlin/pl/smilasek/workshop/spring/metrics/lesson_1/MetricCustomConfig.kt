package pl.smilasek.workshop.spring.metrics.lesson_1

import io.micrometer.core.instrument.MeterRegistry
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.net.InetAddress

@Configuration
class MetricCustomConfig {

    @Bean
    fun secondMetricsCustomizer() = MeterRegistryCustomizer { it: MeterRegistry ->
        it.config()
                .commonTags("ipAddress", InetAddress.getLocalHost().hostAddress)
                .meterFilter(LogbackRenamingMeterFilter())
    }

}