import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested

class RockPaperScissorKtTest {

    @Nested
    inner class TestGetRandomActions {
        @Test
        fun `test getRandomActions has a return value`() {
            assertNotNull(getRandomActions(10))
        }

        @Test
        fun `test getRandomActions returns a list of integers`() {
            assertTrue(getRandomActions(10) is List<Int>)
        }

        @Test
        fun `test getRandomActions returns a non-empty list`() {
            assertTrue(getRandomActions(10).isNotEmpty())
        }

        @Test
        fun `test getRandomActions returns a list with size n`() {
            assertTrue(getRandomActions(10).size == 10)
        }

        @Test
        fun `test getRandomActions returns a random list with values 0 1 2`() {
            assertTrue(getRandomActions(10).all { it in 0..3 })
        }
    }

    @Nested
    inner class TestMapActionsToResult {

        @Test
        fun `test mapActionsToResult has a return value`() {
            assertNotNull(mapActionsToResult())
        }
    }
}