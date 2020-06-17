import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RockPaperScissorKtTest {

    @Test
    fun `test getRandomActions has a return value`() {
        assertNotNull(getRandomActions())
    }
}