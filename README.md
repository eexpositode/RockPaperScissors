# RockPaperScissors

This code challenge focuses on **clean code**, a good **test coverage** and an **appropriate design**. It has been accomplished using [Kotlin](https://kotlinlang.org/) and [JUnit 5](https://junit.org/junit5/) on the [IntelliJ IDE](https://www.jetbrains.com/idea/).

## Problem Statement

Write a program that plays multiple rounds of Rock, Paper, Scissors (https://en.wikipedia.org/wiki/Rock-paper-scissors) and shows the final results of the game.The code should at least provide the minimal functional requirements listed below, have high test coverage and adhere to common clean code rules.
KEEP IT SIMPLE - remember: we're not looking for a full-blown business application, but a basis for discussion and further development. A simple text output for the result will do.

### Minimal functional requirements:

- [x] One player should always play randomly, the other should always choose rock.
- [x] The application should play at least 100 rounds of the game
- [x] The application should evaluate the game logic, i.e. the result (e.g. WIN, DRAW, LOSE) of two actions (e.g. ROCK, PAPER, SCISSOR) competing against each other
- [x] The application should calculate at least the number of wins for each player and the number of draws.
 
### Technical requirements

- [x] Language: Kotlin, tests in a language and with a framework of your choice
- [x] Approach: ideally "test-driven

## Run it!

Clone the git repository locally and open it using **Intellij**. The project will build and get ready to be executed.

In order to set a custom input parameter just change the "Run Configuration" and enter the desired value under "Program Arguments" 

## Future work

- [ ] Use enums to map actions instead of using Integers: 
    * Stone - 0
    * Paper - 1
    * Scissors - 2
- [ ] Use enums to map results instead of using Integers: 
    * Draw - 0
    * Win - 1
    * Loss - 2
- [ ] Allow both players to play randomly

## Built With

* [Kotlin](https://kotlinlang.org/)
* [JUnit 5](https://junit.org/junit5/)
* [Gradle](https://gradle.org/)
* [IntelliJ IDE](https://www.jetbrains.com/idea/).