package e.scope

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val main = Dispatchers.Default
        val coroutineScope = CoroutineScope(main)
        coroutineScope.launch {
            repeat(100) {
                println("counting.. $it")
                delay(100)
            }
        }

        launch {
            delay(500)
            coroutineScope.cancel()
        }
    }
}