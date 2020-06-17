import kotlin.random.Random

fun main() {
    print("Hello World")
}

//TODO playRockPaperScissor() : Void
//TODO mapActionsToResult(actionPlayer1: Int, actionPlayer2: Int) : Int
fun mapActionsToResult(randomAction: Int) = when (randomAction) {
    0 -> 0
    else -> 1
}

/**
 * Given the amount of game rounds n, returns a random list of integer with size n
 * @param gameRounds Amount of rounds in the game
 * @return Random List<Int> with size gameRounds
 */
fun getRandomActions(gameRounds: Int) = List(gameRounds) { Random.nextInt(3) }