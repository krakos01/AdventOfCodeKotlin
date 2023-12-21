fun main() {
    fun part1(input: List<String>): Int {
        var ret = 1
        var data = input[0].split(':')[1]
        var nData = data.dropWhile { c -> c.isWhitespace() } .replace("\\s+".toRegex(), "|")
        val times = nData.split('|')

        data = input[1].split(':')[1]
        nData = data.dropWhile { c -> c.isWhitespace() } .replace("\\s+".toRegex(), "|")
        val records = nData.split('|')


        for (i in times.indices) {
            val time = times[i].toInt()
            var sum = 0
            for (j in 0..time/2) {
                if (j*(time-j) > records[i].toInt()) {
                    sum += if (j==time-j) 1
                    else 2
                }
            }
            ret *= sum
        }
        return ret
    }


    fun part2(input: List<String>): Int {
        var data = input[0].split(':')[1]
        val time = data.dropWhile { c -> c.isWhitespace() } .replace("\\s+".toRegex(), "").toLong()

        data = input[1].split(':')[1]
        val record = data.dropWhile { c -> c.isWhitespace() } .replace("\\s+".toRegex(), "").toLong()

        var ret = 0
        for (j in 0..time/2) {
            if (j*(time-j) > record) {
                ret += if (j==time-j) 1
                else 2
            }
        }

        return ret
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    part2(testInput).println()
    //check(part1(testInput) == 288)

    val input = readInput("Day06")
    part1(input).println()
    part2(input).println()
}
