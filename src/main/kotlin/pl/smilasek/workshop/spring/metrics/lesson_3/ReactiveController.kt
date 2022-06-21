package pl.smilasek.workshop.spring.metrics.lesson_3

import io.micrometer.core.annotation.Timed
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux
import reactor.kotlin.core.publisher.toMono
import java.time.Duration.ofSeconds

@RestController
class ReactiveController(
    private val reactiveDelegate: ReactiveDelegate
) {


    @GetMapping("/flux")
    @Timed(value = "reactive.aspect.flux")
    fun flux(): Flux<Int> = reactiveDelegate.flux()

    @GetMapping("/mono")
    @Timed(value = "reactive.aspect.mono")
    fun mono(): Mono<Int> = reactiveDelegate.mono(2)

//    @GetMapping("/errors")
//    fun error(): Mono<Int> = Random.nextInt(1, 5).toMono()
//        .map { throwExceptionForEvenNumber(it) }
//        .measure("reactive.errors.metrics")
//
//    private fun throwExceptionForEvenNumber(int: Int) =
//        if (int % 2 == 0) throw RuntimeException("even number") else int

}


@Component
class ReactiveDelegate {

    @Timed(value = "reactive.aspect.flux.delegate")
    fun flux() = (1..3).toFlux()
//        .measure("reactive.flux.metrics_1")
        .flatMap { mono(it) }
//        .measure("reactive.flux.metrics_2")

    @Timed(value = "reactive.aspect.mono.delegate")
    fun mono(int: Int): Mono<Int> = int.toMono()
//        .measure("reactive.mono.metrics_1")
        .delayElement(ofSeconds(int.toLong()))
//        .measure("reactive.mono.metrics_2")
}


fun <T> Mono<T>.measure(name: String): Mono<T> = name(name).metrics()
fun <T> Flux<T>.measure(name: String): Flux<T> = name(name).metrics()