class Bag(
    var redCube: Int = 0,
    var greenCube: Int = 0,
    var blueCube: Int = 0
) {
    fun setBagFromData(bag: List<String>): Bag {
        bag.forEach {
            if (it.contains("red"))
                this.redCube = it.filter { c -> c.isDigit() }.toInt()
            else if(it.contains("green"))
                this.greenCube = it.filter { c -> c.isDigit() }.toInt()
            else if(it.contains("blue"))
                this.blueCube = it.filter { c -> c.isDigit() }.toInt()
        }

        return this
    }

    fun isBagPossible(): Boolean {
        return redCube<=12 && greenCube<=13 && blueCube<=14
    }
}

class Game(
    var gameId: Int = 0,
    var bags: MutableList<Bag> = mutableListOf()
) {
    fun getGameFromData(game: String) : Game{
        this.gameId = game.split(':')[0].takeLastWhile { it.isDigit() }.toInt()
        val stringData = game.split(':')[1].split(';')
        for (s in stringData) {
            val colorsNumbers = s.split(',')
            val bag = Bag().setBagFromData(colorsNumbers)
            bags.add(bag)
        }
        return this
    }

    fun isGamePossible(): Boolean {
        for (set in bags) if(!set.isBagPossible()) return false

        return true
    }

}


fun main() {
    fun part1(input: List<String>): Int {
        val allGames = mutableListOf<Game>()
        var possibleGamesIdsSum = 0

        input.forEach { s -> allGames.add(Game().getGameFromData(s)) }
        allGames.forEach { game ->
            if (game.isGamePossible()) possibleGamesIdsSum+=game.gameId
        }

        return possibleGamesIdsSum
    }


    fun part2(input: List<String>): Int {
        // Load data
        val allGames = mutableListOf<Game>()
        input.forEach { s -> allGames.add(Game().getGameFromData(s)) }

        var maxColors = mutableListOf<Int>(-1,-1,-1)
        var sum = 0

        for (game in allGames) {
            game.bags.forEach {
                if (it.redCube>maxColors[0]) maxColors[0]=it.redCube
                if (it.greenCube>maxColors[1]) maxColors[1]=it.greenCube
                if (it.blueCube>maxColors[2]) maxColors[2]=it.blueCube
            }
            sum += maxColors[0]*maxColors[1]*maxColors[2]
            maxColors = mutableListOf(-1,-1,-1)

        }

        return sum
    }



    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    part2(testInput)

    check(part2(testInput) == 2286)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()



}
