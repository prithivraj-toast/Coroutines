import g.testing.BusinessLogic
import g.testing.Service
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import java.util.concurrent.TimeUnit

@ExperimentalCoroutinesApi
class BusinessLogicTest {
    private val mockService: Service = mockk(relaxed = true)
    private val businessLogic = BusinessLogic(mockService)

    @Test
    fun testLogic() = runBlockingTest {
        businessLogic.execute("test")
        verify(exactly = 5) { mockService.query("Test") }
    }

    @Test
    fun testTiming() {
        val testCoroutineDispatcher = TestCoroutineDispatcher()
        testCoroutineDispatcher.runBlockingTest {
            launch {
                businessLogic.execute("test")
            }
            verify(exactly = 1) { mockService.query("Test") }
            testCoroutineDispatcher.advanceTimeBy(TimeUnit.SECONDS.toMillis(2))
            verify(exactly = 2) { mockService.query("Test") }
            testCoroutineDispatcher.advanceTimeBy(TimeUnit.SECONDS.toMillis(7))
            verify(exactly = 5) { mockService.query("Test") }
        }
    }
}