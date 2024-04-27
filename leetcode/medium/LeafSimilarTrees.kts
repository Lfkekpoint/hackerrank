/** https://leetcode.com/problems/leaf-similar-trees/
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()

        dfs(root1, list1)
        dfs(root2, list2)

        return list1 == list2
    }

    fun dfs(node: TreeNode?, list: MutableList<Int>) {
        if (node?.left == null && node?.right == null) {
            node?.`val`?.let { list.add(it) }
        } else {
            node.left?.let { dfs(it, list) }
            node.right?.let { dfs(it, list) }
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

// better solution with Exception on second try

class Solution2 {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()

        dfs1(root1, list1)

        try {
            dfs2(root2, list2, list1)
        } catch (e: NonSimilarException) {
            return false
        }

        return list1 == list2
    }

    fun dfs1(node: TreeNode?, listOriginal: MutableList<Int>) {
        if (node?.left == null && node?.right == null) {
            node?.`val`?.let {
                listOriginal.add(it)
            }
        } else {
            node.left?.let { dfs1(it, listOriginal) }
            node.right?.let { dfs1(it, listOriginal) }
        }
    }

    fun dfs2(node: TreeNode?, listOriginal: MutableList<Int>, listForCompare: MutableList<Int>) {
        if (node?.left == null && node?.right == null) {
            node?.`val`?.let {
                listOriginal.add(it)
                if (listOriginal.size <= listForCompare.size && it != listForCompare[listOriginal.size - 1]) {
                    throw NonSimilarException()
                }
            }
        } else {
            node.left?.let { dfs2(it, listOriginal, listForCompare) }
            node.right?.let { dfs2(it, listOriginal, listForCompare) }
        }
    }

    class NonSimilarException : Exception("This TreeNods are not similar")

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}