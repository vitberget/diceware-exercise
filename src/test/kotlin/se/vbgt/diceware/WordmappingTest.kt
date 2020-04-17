package se.vbgt.diceware

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import se.vbgt.diceware.DiceWareUtil.mapWords


internal class WordmappingTest {

    @Test
    fun notEnoughDiceInDiceGroups() {
        assertThrows(IllegalArgumentException::class.java) {
            mapWords()
        }

        assertThrows(IllegalArgumentException::class.java) {
            mapWords(
                emptyList()
            )
        }


        assertThrows(IllegalArgumentException::class.java) {
            mapWords(
                listOf(1)
            )
        }

        assertThrows(IllegalArgumentException::class.java) {
            mapWords(
                listOf(1, 2, 3, 4)
            )
        }

        assertThrows(IllegalArgumentException::class.java) {
            mapWords(
                listOf(1, 2, 3, 4, 5),
                listOf(1, 2, 3, 4)
            )
        }
    }

    @Test
    fun toManyDice() {
        assertThrows(IllegalArgumentException::class.java) {
            mapWords(
                listOf(1, 2, 3, 4, 5, 6)
            )
        }

        assertThrows(IllegalArgumentException::class.java) {
            mapWords(
                listOf(1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6)
            )
        }

        assertThrows(IllegalArgumentException::class.java) {
            mapWords(
                listOf(1, 2, 3, 4, 5),
                listOf(1, 2, 3, 4, 5, 6)
            )
        }
    }

    @Test
    fun mapOneWord() {
        val result = mapWords(
            listOf(1, 1, 1, 1, 1)
        )
        assertEquals(1, result.size)
        assertEquals(result.keys.first(), listOf(1, 1, 1, 1, 1))
        assertEquals("a", result.values.first())
    }

    /**
     * Test wordlist for:
     * 33462	hymen
     * 22341	dante
     */
    @Test
    fun mapTwoWords() {
        val result = mapWords(
            listOf(3, 3, 4, 6, 2),
            listOf(2, 2, 3, 4, 1)
        )

        assertEquals(2, result.size)
        assertEquals("dante", result[listOf(2, 2, 3, 4, 1)])
        assertEquals("hymen", result[listOf(3, 3, 4, 6, 2)])
    }

    @Test
    fun identicalDicerollsAggregates() {
        val result = mapWords(
            listOf(2, 6, 6, 3, 6),
            listOf(2, 6, 6, 3, 6)
        )

        assertEquals(1, result.size)
        assertEquals(listOf(2, 6, 6, 3, 6), result.keys.first())
        assertEquals("gauge", result.values.first())
    }
}