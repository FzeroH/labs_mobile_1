package com.example.ru.lab_sqlite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ru.App
import com.example.ru.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodosAdapter(clickInterface: ClickInterface): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var todosList : List<TodosEntity> = ArrayList()

    val click = clickInterface

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.todos_item, parent, false)
        return TodosViewHolder(itemView = itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TodosViewHolder) {
            holder.bind(item = todosList[position])
        }
    }

    override fun getItemCount(): Int {
        return todosList.count()
    }

    fun setData(newTodosList: List<TodosEntity>){
        todosList = newTodosList
    }

    inner class TodosViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        private var done: CheckBox  = itemView.findViewById(R.id.done)
        private var todo: TextView = itemView.findViewById(R.id.todo)
        private var delete: ImageView = itemView.findViewById(R.id.delete)
        private val job = CoroutineScope(Dispatchers.Main)

        fun bind(item: TodosEntity){
            todo.text = item.todo
            delete.setOnClickListener {
                click.deleteTodo(item.id)
            }
        }
    }
    interface ClickInterface{
        fun deleteTodo(id: Int)
    }
}