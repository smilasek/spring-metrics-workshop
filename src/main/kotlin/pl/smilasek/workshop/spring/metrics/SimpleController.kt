package pl.smilasek.workshop.spring.metrics

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux

@RestController
class SimpleController {

    @GetMapping("/flux")
    fun getRandom(): Flux<String> =
            (1..10).toFlux()
                    .map { it.toString() }
                    .measure("flux")

    @GetMapping("/empty")
    fun emptyMono(): Mono<String> = Mono.empty<String?>().measure("empty")

    @GetMapping("/error")
    fun error(): Mono<String> = Mono.error<String>(RuntimeException()).measure("error")
}

fun <T> Mono<T>.measure(name: String): Mono<T> = name(name).metrics()
fun <T> Flux<T>.measure(name: String): Flux<T> = name(name).metrics()