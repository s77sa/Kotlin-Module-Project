class ArchiveMenu {
    private var archive = mutableListOf<ArchiveData>()
    private val archiveMenu = mutableListOf(
        "Список архивов:",
        "0. Создать архив",
        "1. Выход из программы")
    private val menuHandler = MenuHandler()
    fun start() {
        var input: Int
        while (true) {
            menuHandler.menuPrinter(archiveMenu)
            input = menuHandler.inputHandler()
            when (input) {
                0 -> createArchive()
                1 -> break
                in (archive.indices.first + 2..archive.indices.last + 2) -> inputHandler(input)
                else -> {
                    println("Введите цифру, из списка меню")
                    continue
                }
            }
        }
    }

    private fun inputHandler(input: Int) {
        val noteMenu = NoteMenu()
        noteMenu.show(archive[input - 2])
    }

    private fun createArchive() {
        println("Введите название архива:")
        val name = readln()
        archive.add(ArchiveData(name, arrayListOf()))
        archiveMenu.add("${archiveMenu.size - 1}. $name")
    }
}