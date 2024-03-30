import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'climbingLeaderboard' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY ranked
 *  2. INTEGER_ARRAY player
 */

fun climbingLeaderboard(ranked: Array<Int>, player: Array<Int>): Array<Int> {
    val playersTable = arrayListOf<Int>()
    val playerPlaceTable = arrayListOf<Int>()
    var currentScore = 0
    var nextScore: Int
    ranked.iterator().apply {
        while (hasNext()) {
            nextScore = next()
            if (currentScore != nextScore) {
                currentScore = nextScore
                playersTable.add(currentScore)
            }
        }
    }
    val playersTableFromBottom = playersTable.reversed()
    for (i in player) {
        val binaryResultSearch = playersTableFromBottom.binarySearch {
            it - i
        }
        if (binaryResultSearch >= 0) {
            playerPlaceTable.add(playersTableFromBottom.size - binaryResultSearch)
        } else {
            playerPlaceTable.add(playersTableFromBottom.size - (-binaryResultSearch - 1) + 1)
        }
    }
    return playerPlaceTable.toTypedArray()
}



fun main(args: Array<String>) {
    val rankedCount = readLine()!!.trim().toInt()

    val ranked = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val playerCount = readLine()!!.trim().toInt()

    val player = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = climbingLeaderboard(ranked, player)

    println(result.joinToString("\n"))
}
