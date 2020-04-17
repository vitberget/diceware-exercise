package se.vbgt.diceware

import org.junit.jupiter.api.Test
import se.vbgt.diceware.Dice.rollDice
import kotlin.test.assertTrue

internal class DiceTest {

    /**
     * Because we have learnt that random and intervals is hard ;)
     */
    @Test
    fun sanityCheckDice() {
        val rolls = (1..10_000).map { rollDice() }

        // In 1000 rolls, the likelyhood that there is at least one of each is... good
        assertTrue(rolls.any { it == 1 })
        assertTrue(rolls.any { it == 2 })
        assertTrue(rolls.any { it == 3 })
        assertTrue(rolls.any { it == 4 })
        assertTrue(rolls.any { it == 5 })
        assertTrue(rolls.any { it == 6 })

        // Should not contain results outside 1 to 6
        assertTrue(rolls.none { it < 1 || it > 6 })
    }
}
