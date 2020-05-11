package se.vbgt.diceware

import se.vbgt.diceware.Dice.rollDice
import se.vbgt.diceware.DiceWareUtil.randomLetter

fun main(vararg args: String) {
    println("Diceware kotlinator v13.37")

    val numberOfWords = parseArguments(args)
    val words = getSomeWords(numberOfWords)

    println(words.joinToString(" "))
    println(doRandomLetter(words).joinToString(" "))
}

private fun doRandomLetter(words: List<String>): List<String> {
    val randomNumber = getValidDice(words.size)

    return words.mapIndexed { idx, word ->
        when (idx) {
            randomNumber - 1 -> doRandomLetter(word)
            else -> word
        }
    }
}

fun doRandomLetter(word: String): String {
    val randomNumber = getValidDice(word.length)

    return word.mapIndexed { idx, char ->
        when (idx) {
            randomNumber - 1 -> randomLetter(rollDice(), rollDice())
            else -> char
        }
    }.joinToString("")
}

private fun getValidDice(size: Int): Int {
    require(size > 0)

    while (true) {
        val dice = rollDice()
        if (dice <= size) return dice
    }
}

private fun getSomeWords(numberOfWords: Int) =
    (1..numberOfWords)
        .map { fiveDiceRolls() }
        .map { DiceWareUtil.mapWords(it) }
        .map { it.values.first() }

private fun fiveDiceRolls() = (1..5).map { rollDice() }

private fun parseArguments(args: Array<out String>): Int {
    if (args.isNotEmpty()) {
        try {
            return args.first().toInt()
        } catch (e: NumberFormatException) {
        }
    }

    return 6;
}