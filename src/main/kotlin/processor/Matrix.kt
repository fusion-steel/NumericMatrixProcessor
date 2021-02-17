package processor
import java.util.Scanner

private val scan = Scanner(System.`in`)

class Matrix(var rows: Int, var columns: Int) {
    private val matrix = Array(rows) { Array(columns) {0.0} }

    internal fun setUserMatrix() {
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                matrix[i][j] = scan.next().toDouble()
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
        require(isSameSize(other))
        val plusMatrix = Matrix(rows, columns)
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                plusMatrix.matrix[i][j] = matrix[i][j] + other.matrix[i][j]
            }
        }
        return plusMatrix
    }

    operator fun times(scalar: Double): Matrix {
        val scaledMatrix = Matrix(rows, columns)
        matrix.forEachIndexed { i, rows ->
            rows.forEachIndexed { j, _ ->
                scaledMatrix.matrix[i][j] = matrix[i][j] * scalar }
        }
        return scaledMatrix
    }

    operator fun times(other: Matrix): Matrix {
        val multipliedMatrix = Matrix(other.rows, columns)
        for (i in matrix.indices) {
            for (j in other.matrix[i].indices) {
                for (k in matrix[i].indices) {
                    multipliedMatrix.matrix[i][j] += matrix[i][k] * other.matrix[k][j]
                }
            }
        }
        return multipliedMatrix
    }

    private fun isSameSize(other: Matrix): Boolean = rows == other.rows && columns == other.columns
}

fun readMatrix(): Matrix {
    val rows = scan.nextInt()
    val columns = scan.nextInt()
    val matrix = Matrix(rows, columns)
    matrix.setUserMatrix()
    return matrix
}