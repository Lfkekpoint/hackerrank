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
 * Complete the 'plusMinus' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun plusMinus(arr: Array<Int>): Unit {
    var positiveCount = 0f
    var negativeCount = 0f
    var zeroCount = 0f
    arr.forEach { when {
        it > 0 -> positiveCount++
        it < 0 -> negativeCount++
        else -> zeroCount++
        } 
    }
    println("%.4f".format(positiveCount/arr.size))
    println("%.4f".format(negativeCount/arr.size))
    println("%.4f".format(zeroCount/arr.size))
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    plusMinus(arr)
}
