package org.example

data class Note(val id: Int, val text: String)

abstract class DataBase { // Абстрактный класс для получения данных с базой данных
    abstract fun getAll(): List<Note>
}

class DataBaseLocal : DataBase() { // Класс для получения данных с локальной базой данных
    override fun getAll(): List<Note> = mutableListOf(Note(1, "Note1 1"), Note(2, "Note1 2"))
}

class DataBaseRemote : DataBase() { // Класс для получения данных с удалённой базой данных
     override fun getAll(): List<Note> = mutableListOf(Note(1, "Note2 1"), Note(2, "Note2 2"))
}

class NoteRepositoryImplLocal : NoteRepository { // Реализация репозитория для работы с локальными данными
    override fun getAllNotes(): List<Note> = DataBaseLocal().getAll()
}

class NoteRepositoryImplRemote : NoteRepository { // Реализация репозитория для работы с удалёнными данными
    override fun getAllNotes(): List<Note> = DataBaseRemote().getAll()
}

interface NoteRepository { // Интерфейс для работы с репозиторием заметок
    fun getAllNotes(): List<Note>
}

fun main() {
    val noteRepositoryImplLocal = NoteRepositoryImplLocal()
    val noteRepositoryImplRemote = NoteRepositoryImplRemote()

    // Выводим список заметок из локальной базы данных
    println(noteRepositoryImplLocal.getAllNotes())
    //    [Note(id=1, text=Note1 1), Note(id=2, text=Note1 2)]

    // Выводим список заметок из удалённой базы данных
    println(noteRepositoryImplRemote.getAllNotes())
    //    [Note(id=1, text=Note2 1), Note(id=2, text=Note2 2)]
}