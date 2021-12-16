package com.example.ru.lab_sqlite

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ru.App
import com.example.ru.R

class SQLiteActivity : AppCompatActivity(), TodosAdapter.ClickInterface {

    private lateinit var addTextTodo: TextView
    private lateinit var addTodo: Button
    private lateinit var listTodos: RecyclerView
    private val adapter = TodosAdapter(this)
    private val todosViewModel:TodosViewModel by viewModels {
        ViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        addTextTodo = findViewById(R.id.add_text_todo)
        addTodo = findViewById(R.id.add_todo)
        listTodos = findViewById(R.id.list_todos)
        listTodos.layoutManager = LinearLayoutManager(this)
        listTodos.adapter = adapter

        addTodo.setOnClickListener{
            addTodo()
            getAllTodos(this)
        }
    }

    override fun onStart() {
        super.onStart()
        getAllTodos(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        todosViewModel.todosLiveData.removeObservers(this)
    }

    @SuppressLint("ResourceAsColor")
    private fun addTodo() {
        val contact = TodosEntity(
            todo = addTextTodo.text.toString(),
            done = false
        )
        if (addTextTodo.text.toString() == ""){
            Toast.makeText(this,"Заполните поле", LENGTH_SHORT).show()
        }else {
            addTextTodo.setBackgroundColor(R.color.white)
            todosViewModel.addTodo(contact)
            addTextTodo.text = ""
        }
    }

    private fun getAllTodos(owner: LifecycleOwner){
        todosViewModel.todosLiveData.observe(owner){ contact ->
            contact.let{adapter.setData(it)}
        }
    }

    override fun deleteTodo(id: Int) {
        todosViewModel.deleteTodo(id)
        Log.d("DELETE_TEST",id.toString())
    }
}