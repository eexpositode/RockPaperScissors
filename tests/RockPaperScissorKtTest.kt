import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RockPaperScissorKtTest {

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
}