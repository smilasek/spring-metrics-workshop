package pl.smilasek.workshop.spring.metrics

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringMetricsWorkshopApplication

fun main(args: Array<String>) {
	runApplication<SpringMetricsWorkshopApplication>(*args)
}
