class NoteMenu {

    private val notesMenu = mutableListOf(
        "Список заметок:",
        "0. Создать заметку",
        "1. Назад")
    private val menuHandler = MenuHandler()

    fun show(archive: ArchiveData) {
        if (archive.note.isNotEmpty()) {
            for (i in archive.note.indices) {
                notesMenu.add("${i + 2}. ${archive.note[i].name}")
            }
        }
        var input: Int
        while (true) {
            menuHandler.menuPrinter(notesMenu)
            input = menuHandler.inputHandler()
            when (input) {
                0 -> createNote(archive)
                1 -> break
                in (archive.note.indices.first + 2..archive.note.indices.last + 2) -> start(archive.note[input - 2])
                else -> {
                    println("Введите цифру, из списка меню")
                    continue
                }
            }
        }
    }

    private fun createNote(archive: ArchiveData) {
        println("Введите название заметки:")
        val name = readln()
        println("Введите текст заметки:")
        val text = readln()
        archive.note.add(NoteData(name, text))
        notesMenu.add("${notesMenu.size - 1}. $name")
    }

    private fun start(note: NoteData) {
        val noteMenu = mutableListOf(
            "Название заметки: ${note.name}",
            "Текст заметки", note.text,
            "1. Назад")
        var input: Int
        while (true) {
            menuHandler.menuPrinter(noteMenu)
            input = menuHandler.inputHandler()
            when (input) {
                1 -> break
                else -> {
                    println("Введите 1, чтобы вернуться назад")
                    continue
                }
            }
        }
    }
}
