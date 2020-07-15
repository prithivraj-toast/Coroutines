package b.light

import kotlinx.coroutines.*

// Coroutines are light-weight
fun main() = runBlocking {
    repeat(100_000) { // launch a lot of coroutines
        launch {
            delay(1000L)
            print(".")
        }
    }
}