package f.jumping

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        println("Started in ${Thread.currentThread().name}")
        withContext(Dispatchers.IO) {
            println("Working in ${Thread.currentThread().name}")
        }
        println("Back to outer ${Thread.currentThread().name}")
    }
    Unit
}