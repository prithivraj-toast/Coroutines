package a.intro

import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

/*
Here we are launching a new coroutine in the GlobalScope,
meaning that the lifetime of the new coroutine is limited only by the lifetime of the whole application.
 */
fun main() {
    GlobalScope.launch {
        delay(TimeUnit.SECONDS.toMillis(1))
        println("Hello")
    }
    println("World")
    Thread.sleep(2000L) // delay for 2 seconds just to keep JVM alive
}