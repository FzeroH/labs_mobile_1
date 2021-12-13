package com.example.ru.lab_sqlite

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TodosDao {
    
    @Query("SELECT * FROM Todos")
    fun getAllTodos(): Flow<List<TodosEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTodo(todo: TodosEntity)

    @Query("DELETE FROM Todos WHERE 'id' = :id")
    suspend fun deleteTodo(id: Int)

}