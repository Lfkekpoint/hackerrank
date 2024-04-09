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
    class Solution {
        fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
            val resultWrapper = ListNode(0)
            var current1 = l1
            var current2 = l2
            var inner = resultWrapper
            var remain = 0
            while (current1 != null || current2 != null) {
                val x = current1?.`val` ?: 0
                val y = current2?.`val` ?: 0
                val sum = remain + x + y
                remain = sum / 10
                inner.next = ListNode(sum % 10)
                inner = inner.next!!
                if (current1 != null) current1 = current1.next
                if (current2 != null) current2 = current2.next
            }
            if (remain > 0) {
                inner.next = ListNode(remain)
            }
            return resultWrapper.next
        }
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
           val x = Solution().addTwoNumbers(
                ListNode(2).apply { next = ListNode(4).apply { next = ListNode(9) } },
                ListNode(5).apply { next = ListNode(6).apply { next = ListNode(4).apply { next = ListNode(9) } } },
            )

            println(x)
            val y = 0
        }
    }
}