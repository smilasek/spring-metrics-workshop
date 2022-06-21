package pl.smilasek.workshop.spring.metrics.common

import io.micrometer.core.instrument.MeterRegistry
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class MetricsConfiguration {

    @Value("\${spring.application.name}")
    private lateinit var applicationName: String

    @Bean
    fun metricsCommonTags() =
            MeterRegistryCustomizer { it: MeterRegistry -> it.config().commonTags("application", applicationName) }
}