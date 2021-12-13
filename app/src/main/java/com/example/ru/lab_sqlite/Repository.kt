package com.example.ru.lab_sqlite

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class Repository(private val todosDao: TodosDao) {

    val getAllTodos: Flow<List<TodosEntity>> = todosDao.getAllTodos()

    @WorkerThread
    suspend fun addTodo(contact: TodosEntity){
        todosDao.addTodo(contact)
    }

    @WorkerThread
    suspend fun deleteTodo(id: Int) {
        todosDao.deleteTodo(id)
    }
}