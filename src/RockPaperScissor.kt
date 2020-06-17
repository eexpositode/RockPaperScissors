import kotlin.random.Random

fun main() {
    print("Hello World")
}

//TODO playRockPaperScissor() : Void
//TODO mapActionsToResult(actionPlayer1: Int, actionPlayer2: Int) : Int
fun getRandomActions(gameRounds: Int) = List(gameRounds){ Random.nextInt(3) }