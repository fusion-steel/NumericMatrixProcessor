package processor

import java.util.Scanner

fun main() {
    val scan = Scanner(System.`in`)
    val matrix1 = readMatrix()
    val scalar = scan.nextInt()
    (matrix1 * scalar).printMatrix()

//    matrix1.printMatrix()

//    val matrix2 = Matrix.readMatrix()
//    matrix2.printMatrix()

//    try {
//        val addMatrix = matrix1 + matrix2
//        addMatrix.printMatrix()
//        addMatrix * 3
//        addMatrix.printMatrix()
//    } catch (e: IllegalArgumentException) {
//        println("ERROR")
//    }
}
