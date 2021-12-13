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

class TodosAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var todosList : List<TodosEntity> = ArrayList()

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

    class TodosViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        private var done: CheckBox  = itemView.findViewById(R.id.done)
        private var todo: TextView = itemView.findViewById(R.id.todo)
        private var delete: ImageView = itemView.findViewById(R.id.delete)

        fun bind(item: TodosEntity){
            todo.text = item.todo
        }
    }
}