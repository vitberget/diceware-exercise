package se.vbgt.diceware

object DiceWareUtil {

    private val rollWordMap: Map<List<Int>, String> by lazy {
        // Det som är inom paranteserna i regex-strängen är groups,
        // innehållet i group:sen kan man sedan hämta i matchResultet
        // (se mapRegexGroups)
        val regex = """^([0-9]{5})\t(.+)$""".toRegex()

        javaClass.getResource("/se/vbgt/diceware/diceware.wordlist.asc")
            .readText()
            .lines()
            .map { regex.find(it) }
            .filterNotNull() // null = inte match på den raden
            .map { mapRegexGroups(it) }
            .toMap()
    }

    private fun mapRegexGroups(matchResult: MatchResult): Pair<List<Int>, String> {
        val key = matchResult.groupValues[1].map { it - '0' }
        val value = matchResult.groupValues[2]
        return key to value
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
