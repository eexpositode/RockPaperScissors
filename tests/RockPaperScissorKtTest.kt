import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RockPaperScissorKtTest {

    @Test
    fun `test getRandomActions has a return value`() {
        assertNotNull(getRandomActions())
    }

    @Test
    fun `test getRandomActions returns a list of integers`() {
        assertTrue(getRandomActions() is List<Int>)
    }

    @Test
    fun `test getRandomActions returns a non-empty list`() {
        assertTrue(getRandomActions().isNotEmpty())
    }
}