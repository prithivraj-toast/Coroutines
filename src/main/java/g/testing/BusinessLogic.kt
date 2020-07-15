package g.testing

import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit

class BusinessLogic(private val service: Service) {
    suspend fun execute(name: String) {
        repeat(5) {
            service.query(name.capitalize())
            delay(TimeUnit.SECONDS.toMillis(2))
        }
    }
}