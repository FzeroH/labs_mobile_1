package com.example.ru

import android.app.Application
import com.example.ru.lab_sqlite.Repository
import com.example.ru.lab_sqlite.TodosDB

class App: Application() {
    val db by lazy { TodosDB.getDatabase(this@App) }
    val repository by lazy { Repository(db.todosDao()) }
}