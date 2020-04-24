package se.vbgt.diceware

object Dice {
    /**
     * Simulate a six sided dice (values 1 - 6)
     */
    fun rollDice(): Int = (1..6).random()
}