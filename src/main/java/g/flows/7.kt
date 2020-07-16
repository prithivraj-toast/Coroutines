package g.flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() = runBlocking {
    val simpleFlow = flowOf(1, 2, 3, 4, 5)
    simpleFlow.collect {
        println("Simple flow : $it")
    }

    val delayedFlow = flow {
        repeat(5) {
            delay(TimeUnit.SECONDS.toMillis(1))
            emit(it)
        }
    }

    delayedFlow
        .collect {
            println("Delayed flow : $it")
        }
}