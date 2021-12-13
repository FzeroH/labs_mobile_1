package com.example.ru.lab_sqlite

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class TodosViewModel(private val repository: Repository): ViewModel() {

    var todosLiveData : LiveData<List<TodosEntity>> = repository.getAllTodos.asLiveData()

    fun addTodo(todo: TodosEntity) {
        try{
            viewModelScope.launch {
                repository.addTodo(todo)
            }
        }
        catch(e: Exception){
            Log.d("EXCEPTION", "Warning ${e.message}")
        }
    }

    suspend fun deleteTodo(id: Int) {
        try{
            viewModelScope.launch {
                repository.deleteTodo(id)
            }
        }
        catch(e: Exception){
            Log.d("EXCEPTION", "Warning ${e.message}")
        }
    }

}

class ViewModelFactory(private val repository:Repository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TodosViewModel::class.java)){
            return TodosViewModel(repository) as T
        }
        else{
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}