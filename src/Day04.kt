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
        var ret = 0
        var cards = ArrayList<Int>()
        for(i in input.indices) {
            cards.add(1)
        }
        for(i in input.indices) {
            var s = input[i]
            var l = s.split("\\s+".toRegex())
            var winners = HashSet<Int>()
            var iswinner = true
            var amt = 0

            for(b in 2 until l.size) {
                if(l[b] == "|") {
                    iswinner = false
                }
                else {
                    if(iswinner) {
                        winners.add(l[b].toInt())
                    }
                    else {
                        if(winners.contains(l[b].toInt())) {
                            amt++
                        }
                    }
                }
            }
            for(j in 0 until amt) {
                cards[i+j+1] += cards[i]
            }
        }
        for(x in cards) {
            ret += x
        }
        return ret
    }



    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    part1(testInput)
    check(part1(testInput) == 13)

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}
