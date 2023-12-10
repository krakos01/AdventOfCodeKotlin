import kotlin.math.pow

fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        input.forEach {
            val winningNumbers = it.split(':')[1].split('|')[0].split(' ').mapNotNull { n -> n.toIntOrNull() }
            val myNumbers = it.split(':')[1].split('|')[1].split(' ').mapNotNull { n -> n.toIntOrNull() }
            var myInWinning = 0
            myNumbers.forEach { number ->
                if (number in winningNumbers) myInWinning++
            }

            sum += (2.0).pow(myInWinning-1).toInt()
        }

        return sum
    }


    fun part2(input: List<String>): Int {


        return -1
    }



    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    part1(testInput)
    check(part1(testInput) == 13)

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()



}
