package pl.smilasek.workshop.spring.metrics.lesson_1

import io.micrometer.core.instrument.Meter
import io.micrometer.core.instrument.config.MeterFilter

class LogbackRenamingMeterFilter : MeterFilter {

    private val oldMetricPrefix = "logback"
    private val newMetricPrefix = "logging"

    override fun map(id: Meter.Id): Meter.Id =
            if (id.name.startsWith(oldMetricPrefix)) {
                id.withName(id.name.replace(oldMetricPrefix, newMetricPrefix))
            } else {
                id
            }
}