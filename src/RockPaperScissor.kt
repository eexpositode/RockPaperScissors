import java.lang.RuntimeException
import kotlin.random.Random

fun main(args: Array<String>) {
    getRandomActions(100).mapActionsToResults().resultsToStdout()
}

/**
 * Given the amount of game rounds n, returns a random list of integer with size n
 * @param roundsCount Amount of rounds in the game
 * @return Random List<Int> with size gameRounds
 */
fun getRandomActions(roundsCount: Int) = List(roundsCount) { Random.nextInt(3) }

/**
 * Extension function that maps an action to a game result. The assumption is that one player always plays
 * rock while the other one plays randomly.
 * Actions: Stone - 0, Paper - 1, Scissors - 2
 * @return A game result depending on the input action: Draw - 0, Win - 1, Loss - 2
 * @throws RuntimeException if input action not in range 0 .. 3
 */
fun List<Int>.mapActionsToResults() = map { action ->
    when (action) {
        0 -> 0
        1 -> 1
        2 -> 2
        else -> throw RuntimeException("Unexpected input action")
    }
}

/**
 * Maps a list of results to the desired output format
 * - Player 1 Wins / Draws
 * - Player 2 Wins / Draws
 */
fun List<Int>.resultsToStdout() {
    println("Player 1 no. of wins: ${count { it == 1 }}")
    println("Player 1 no. of draws: ${count { it == 0 }}")
    println("Player 2 no. of wins: ${count { it == 2 }}")
    print("Player 2 no. of draws: ${count { it == 0 }}")
}