package processor
import java.util.Scanner

class Matrix(var rows: Int, var columns: Int) {
    private val matrix = Array(rows) { Array(columns) {0} }

    companion object {
        private val scan = Scanner(System.`in`)
        fun readMatrix(): Matrix {
            val rows = scan.nextInt()
            val columns = scan.nextInt()
            val matrix = Matrix(rows, columns)
            matrix.setUserMatrix()
            return matrix
        }
    }

    private fun setUserMatrix() {
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                matrix[i][j] = scan.nextInt()
            }
        }
    }

    fun printMatrix() {
        matrix.forEach {
            println(it.joinToString(" "))
        }
        println()
    }

    operator fun plus(other: Matrix): Matrix {
        val resultMatrix = Matrix(rows, columns)
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                resultMatrix.matrix[i][j] = matrix[i][j] + other.matrix[i][j]
            }
        }
        return resultMatrix
    }

    private fun isSameSize(other: Matrix): Boolean = rows == other.rows && columns == other.columns
}
