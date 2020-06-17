import java.lang.RuntimeException
import kotlin.random.Random

fun main() {
}

fun resultsToStdout(results: List<Int>) {
    println("Player 1 no. of wins: 0")
    println("Player 1 no. of draws: ${results.size}")
    println("Player 2 no. of wins: 0")
    print("Player 2 no. of draws: ${results.size}")
}

/**
 * An input action is mapped to a game result. The assumption is that one player always plays
 * rock while the other one plays randomly.
 * @param action Integer representing an action Stone - 0, Paper - 1, Scissors - 2
 * @return A game result depending on the input action: Draw - 0, Win - 1, Loss - 2
 * @throws RuntimeException if input action not in range 0 .. 3
 */
fun mapActionsToResult(action: Int) = when (action) {
    0 -> 0
    1 -> 1
    2 -> 2
    else -> throw RuntimeException("Unexpected input action")
}

/**
 * Given the amount of game rounds n, returns a random list of integer with size n
 * @param roundsCount Amount of rounds in the game
 * @return Random List<Int> with size gameRounds
 */
fun getRandomActions(roundsCount: Int) = List(roundsCount) { Random.nextInt(3) }