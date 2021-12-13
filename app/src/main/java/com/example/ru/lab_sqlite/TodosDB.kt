package com.example.ru.lab_sqlite

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TodosEntity::class], version = 1, exportSchema = false)
abstract class TodosDB: RoomDatabase() {
    abstract fun todosDao(): TodosDao

    companion object{
        @Volatile
        private var INSTANCE: TodosDB? = null

        fun getDatabase(context: Context): TodosDB{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodosDB::class.java,
                    "Todos")
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }
}