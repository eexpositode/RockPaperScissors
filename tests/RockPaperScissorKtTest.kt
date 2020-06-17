import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.lang.NumberFormatException
import java.util.stream.Stream

internal class RockPaperScissorKtTest {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    inner class TestMain {
        private val stdOutput: ByteArrayOutputStream by lazy { ByteArrayOutputStream() }

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
        fun `test main without input parameters`() {
            main(emptyArray())
            assertTrue(stdOutput.toString().isNotBlank())
        }

        @Test
        fun `test main with invalid input parameter`() {
            assertThrows<NumberFormatException> { main(arrayOf("Hello")) }
        }
    }

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
            assertNotNull(emptyList<Int>().mapActionsToResults())
        }

        @Test
        fun `test mapActionsToResult returns a list of integers`() {
            assertTrue(emptyList<Int>().mapActionsToResults() is List<Int>)
        }

        @Test
        fun `test mapActionsResult results`() {
            assertEquals(arrayListOf(0, 1, 2), arrayListOf(0, 1, 2).mapActionsToResults())
        }

        @Test
        fun `test mapActionsResult throws an Exception on unknown input action`() {
            assertThrows<RuntimeException> { arrayListOf(5).mapActionsToResults() }
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    inner class TestResultsToStdout {

        private val stdOutput: ByteArrayOutputStream by lazy { ByteArrayOutputStream() }

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
            emptyList<Int>().resultsToStdout()
            assertTrue(stdOutput.toString().isNotBlank())
        }

        @Test
        fun `test resultsToStdout prints 4 lines`() {
            emptyList<Int>().resultsToStdout()
            assertEquals(4, stdOutput.toString().split("\n").size)
        }

        @Test
        fun `test resultsToStdout prints wins and draws for each player`() {
            emptyList<Int>().resultsToStdout()
            stdOutput.toString().split("\n").let {
                assertTrue(it[0].startsWith("Player 1 no. of wins: "))
                assertTrue(it[1].startsWith("Player 1 no. of draws: "))
                assertTrue(it[2].startsWith("Player 2 no. of wins: "))
                assertTrue(it[3].startsWith("Player 2 no. of draws: "))
            }
        }

        @Suppress("unused")
        private fun generateArgumentsStream() = Stream.of(
                Arguments.of(List(10) { 0 }, 0, 10, 0, 10),
                Arguments.of(List(10) { 1 }, 10, 0, 0, 0),
                Arguments.of(List(10) { 2 }, 0, 0, 10, 0),
                Arguments.of(arrayListOf(0, 1, 0, 2, 1, 1, 1, 2, 2, 0), 4, 3, 3, 3)
        )

        @ParameterizedTest
        @MethodSource("generateArgumentsStream")
        fun `test resultsToStdout when results are all draws`(
                results: List<Int>,
                expectedPlayerAWins: Int,
                expectedPlayerADraws: Int,
                expectedPlayerBWins: Int,
                expectedPlayerBDraws: Int
        ) {
            results.resultsToStdout()
            stdOutput.toString().split("\n").let {
                assertTrue(it[0].startsWith("Player 1 no. of wins: $expectedPlayerAWins"))
                assertTrue(it[1].startsWith("Player 1 no. of draws: $expectedPlayerADraws"))
                assertTrue(it[2].startsWith("Player 2 no. of wins: $expectedPlayerBWins"))
                assertTrue(it[3].startsWith("Player 2 no. of draws: $expectedPlayerBDraws"))
            }
        }
    }
}