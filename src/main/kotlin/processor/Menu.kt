package processor

import java.util.Scanner

enum class Menu(val description: String) {
    EXIT("Exit"),
    ADD("Add matrices"),
    MUL_C("Multiply matrix by a constant"),
    MUL_M("Multiply matrices"),
}

fun run() {
    val sin = Scanner(System.`in`)
    while (true) {
        for (i in Menu.values().filter { it != Menu.EXIT }) {
            println("${i.ordinal}. ${i.description}")
        }
        println("${Menu.EXIT.ordinal}. ${Menu.EXIT.description}")
        print("Your choice: ")

        val result = when (sin.nextInt()) {
            1 -> { print("Enter size of first matrix: ")
                val first = readMatrix()
                print("Enter size of second matrix: ")
                val second = readMatrix()
                first + second }
            2 -> { print("Enter size of matrix: ")
                val first = readMatrix()
                first * sin.next().toDouble() }
            3 -> { print("Enter size of first matrix: ")
                val first = readMatrix()
                print("Enter size of second matrix: ")
                val second = readMatrix()
                first * second }
            else -> break
        }

        println("The result is:")
        result.printMatrix()
    }
}