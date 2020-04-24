package se.vbgt.diceware

object DiceWareUtil {

    private val rollWordMap: Map<List<Int>, String> by lazy {
        DiceWareUtil.javaClass.getResource("/se/vbgt/diceware/diceware.wordlist.asc")
            .readText()
            .lines()
            .filter { it.isNotEmpty() }
            .map { it.split("""\t""".toRegex()) }
            .filter { it.size == 2 }
            .map { it[0].toCharArray().toList().map { it - '0' } to it[1] }
            .toMap()
    }

    fun mapWords(vararg wordRoll: List<Int>): Map<List<Int>, String> {
        require(wordRoll.isNotEmpty())
        require(wordRoll.none { it.size != 5 })

        return wordRoll
            .distinct()
            .map { it to (rollWordMap.getOrElse(it) { "" }) }
            .toMap()
    }

    private val randomLetters =
        listOf(
            """~!#$%^""",
            """&*()-=""",
            """+[]\{}""",
            """:;"'<>""",
            """?/0123""",
            """456789"""
        )

    fun randomLetter(horizontalDice: Int, verticalDice: Int): Char =
        randomLetters[verticalDice - 1][horizontalDice - 1]
}
