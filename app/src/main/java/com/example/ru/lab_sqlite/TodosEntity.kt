package com.example.ru.lab_sqlite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "Todos")
data class TodosEntity(
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id") val id:Int = 0,
    @ColumnInfo(name = "todo") val todo: String,
    @ColumnInfo(name = "done") val done: Boolean
)