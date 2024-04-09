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

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val sb1 = StringBuilder()
        val sb2 = StringBuilder()
        buildNodesAsStrings(sb1, sb2, l1, l2)

        val resultNodeString = (sb1.toString().replace("null", "").reversed().toInt() + sb2.toString().replace("null", "").reversed().toInt()).toString()

        var resultNode: ListNode? = null
        resultNodeString.forEach { ch ->
            resultNode = buildNode(resultNode, ch)
        }

        return resultNode
    }

    fun buildNodesAsStrings(
        sb1: StringBuilder,
        sb2: StringBuilder,
        l1: ListNode?,
        l2: ListNode?,
    ) {
        sb1.append(l1?.`val`)
        sb2.append(l2?.`val`)
        l1?.next?.let {
            buildNodesAsStrings(sb1, sb2, l1?.next, l2?.next)
        }
    }

    fun buildNode(currentNode: ListNode?, ch: Char): ListNode {
        val node = ListNode(ch.digitToInt())
        node.next = currentNode
        return node
    }
}