package processor

fun main() {
    val matrix1 = Matrix.readMatrix()
    matrix1.printMatrix()

    val matrix2 = Matrix.readMatrix()
    matrix2.printMatrix()

    val addMatrix = matrix1 + matrix2
    addMatrix.printMatrix()
}
