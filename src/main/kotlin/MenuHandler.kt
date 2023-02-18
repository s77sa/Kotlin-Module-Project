class MenuHandler {
    fun menuPrinter(menu: MutableList<String>) {
        for (i in menu) {
            println(i)
        }
    }

    fun inputHandler(): Int {
        var input: Int = -1
        while (input < 0) {
            try {
                input = readln().toInt()
            } catch (e: Exception) {
                println("Введите цифру из пункта меню")
            }
        }
        return input
    }
}