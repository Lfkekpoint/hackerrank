// https://leetcode.com/problems/spiral-matrix/

class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = mutableListOf<Int>()
        // "c" = "current"
        val cLeftBorder = 0
        val cTopBorder = 0
        val cRightBorder = matrix[0].size - 1
        val cBottomBorder = matrix.size - 1

        var cInnerLevel = 0

        print(matrix.size*matrix[0].size)

        while (result.size != matrix.size*matrix[0].size) {
            for (i in cLeftBorder + cInnerLevel .. cRightBorder - cInnerLevel) {
                result.add(matrix[cTopBorder + cInnerLevel][i])
            }

            if (result.size == matrix.size*matrix[0].size) return result

            for (i in cTopBorder + cInnerLevel + 1 .. cBottomBorder - cInnerLevel) {
                result.add(matrix[i][cRightBorder - cInnerLevel])
            }

            if (result.size == matrix.size*matrix[0].size) return result

            for (i in cRightBorder - cInnerLevel - 1 downTo cLeftBorder + cInnerLevel) {
                result.add(matrix[cBottomBorder - cInnerLevel][i])
            }

            if (result.size == matrix.size*matrix[0].size) return result

            for (i in cBottomBorder - cInnerLevel - 1 downTo cTopBorder + cInnerLevel + 1) {
                result.add(matrix[i][cLeftBorder + cInnerLevel])
            }

            cInnerLevel++
        }

        return result
    }
}

// after coder refactor, на Java данное решение выдает 0 мсек ROFL

class Solution2 {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = mutableListOf<Int>()
        // "c" = "current"
        val cRightBorder = matrix[0].size - 1
        val cBottomBorder = matrix.size - 1

        var cInnerLevel = 0

        while (result.size != matrix.size*matrix[0].size) {
            for (i in cInnerLevel .. cRightBorder - cInnerLevel) {
                result.add(matrix[cInnerLevel][i])
            }

            if (result.size == matrix.size*matrix[0].size) return result

            for (i in cInnerLevel + 1 .. cBottomBorder - cInnerLevel) {
                result.add(matrix[i][cRightBorder - cInnerLevel])
            }

            if (result.size == matrix.size*matrix[0].size) return result

            for (i in cRightBorder - cInnerLevel - 1 downTo cInnerLevel) {
                result.add(matrix[cBottomBorder - cInnerLevel][i])
            }

            if (result.size == matrix.size*matrix[0].size) return result

            for (i in cBottomBorder - cInnerLevel - 1 downTo cInnerLevel + 1) {
                result.add(matrix[i][cInnerLevel])
            }

            cInnerLevel++
        }

        return result
    }
}