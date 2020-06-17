import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.lang.RuntimeException

internal class RockPaperScissorKtTest {

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
            assertEquals(getRandomActions(10).size, 10)
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
            assertNotNull(mapActionsToResult(0))
        }

        @Test
        fun `test mapActionsToResult returns an integer`() {
            assertTrue(mapActionsToResult(0) is Int)
        }

        @ParameterizedTest
        @CsvSource("0, 0", "1, 1", "2, 2")
        fun `test mapActionsResult results`(input: Int, result: Int) {
            assertEquals(result, mapActionsToResult(input))
        }

        @Test
        fun `test mapActionsResult throws an Exception on unknown input action`() {
            assertThrows(RuntimeException::class.java) { mapActionsToResult(5) }
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    inner class TestResultsToStdout {

        private val stdOutput : ByteArrayOutputStream by lazy { ByteArrayOutputStream() }

        @BeforeEach
        fun setUp() {
            System.setOut(PrintStream(stdOutput))
        }

        @AfterEach
        fun tearDown() {
            System.setOut(System.out)
            stdOutput.reset()
        }

        @Test
        fun `test resultsToStdout prints on the stout`() {
            resultsToStdout(emptyList())
            assertTrue(stdOutput.toString().isNotBlank())
        }

        @Test
        fun `test resultsToStdout prints 4 lines`() {
            resultsToStdout(emptyList())
            assertEquals(4, stdOutput.toString().split("\n").size)
        }

        @Test
        fun `test resultsToStdout prints wins and draws for each player`() {
            resultsToStdout(emptyList())
            stdOutput.toString().split("\n").let {
                assertTrue(it[0].startsWith("Player 1 no. of wins: "))
                assertTrue(it[1].startsWith("Player 1 no. of draws: "))
                assertTrue(it[2].startsWith("Player 2 no. of wins: "))
                assertTrue(it[3].startsWith("Player 2 no. of draws: "))
            }
        }

        @Test
        fun `test resultsToStdout when results are all draws`() {
            resultsToStdout(List(10) {0})
            stdOutput.toString().split("\n").let {
                assertTrue(it[0].startsWith("Player 1 no. of wins: 0"))
                assertTrue(it[1].startsWith("Player 1 no. of draws: 10"))
                assertTrue(it[2].startsWith("Player 2 no. of wins: 0"))
                assertTrue(it[3].startsWith("Player 2 no. of draws: 10"))
            }
        }
    }
}