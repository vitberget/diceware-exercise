package se.vbgt.diceware

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import se.vbgt.diceware.DiceWareUtil.randomLetter

internal class RandomLetterTest {
    @Test
    fun someLettersTest() {
        assertEquals('~', randomLetter(1, 1))
        assertEquals('*', randomLetter(2, 2))
        assertEquals('9', randomLetter(6, 6))
        assertEquals('4', randomLetter(1, 6))
        assertEquals('^', randomLetter(6, 1))
    }
}