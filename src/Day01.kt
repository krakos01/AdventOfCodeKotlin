fun main() {
    fun part1(input: List<String>): Int {
        val numbers = mutableListOf<Int>()
        var calVal = ""

        input.forEach { str ->
            calVal += (str.first { it.isDigit() })
            calVal += (str.last { it.isDigit() })
            numbers.add(calVal.toInt())
            calVal = ""
        }

        return numbers.sum()
    }

    fun part2(input: List<String>): Int {
        val numbersMap = mapOf(
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9,
            "zero" to 0
        )

        val numbers = mutableListOf<Int>()
        var calVal = ""
        var firstDigitIndex: Int
        var lastDigitIndex: Int
        var firstTextIndex: Pair<Int, String>
        var lastTextIndex: Pair<Int, String>

        input.forEach { str ->
            firstDigitIndex = str.indexOfFirst { it.isDigit() }
            lastDigitIndex = str.indexOfLast { it.isDigit() }
            firstTextIndex = str.findAnyOf(numbersMap.keys, ignoreCase = true) ?: Pair(firstDigitIndex+1,"")
            lastTextIndex = str.findLastAnyOf(numbersMap.keys, ignoreCase = true) ?: Pair(lastDigitIndex-1,"")

            calVal +=
                if (firstDigitIndex<firstTextIndex.first) str[firstDigitIndex] else numbersMap[firstTextIndex.second]
            calVal +=
                if (lastDigitIndex>lastTextIndex.first) str[lastDigitIndex] else numbersMap[lastTextIndex.second]
            numbers.add(calVal.toInt())
            calVal = ""
        }

        return numbers.sum()
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    // check(part1(testInput) == 142)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()

}
