package processor

enum class Menu(val description: String) {
    EXIT("Exit"),
    ADD("Add matrices"),
    MUL_C("Multiply matrix by a constant"),
    MUL_M("Multiply matrices"),
}

fun run() {
    while (true) {
        for (i in Menu.values().filter { it != Menu.EXIT }) {
            println("${i.ordinal}. ${i.description}")
        }
        println("${Menu.EXIT.ordinal}. ${Menu.EXIT.description}")
        break
    }
}