package d.job

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val job = launch {
            val internalJob = coroutineContext[Job]
            repeat(100) {
                println("${internalJob.toString()} $it")
                delay(100)
            }
        }

        launch {
            delay(500)
            job.cancel()
        }
    }
}