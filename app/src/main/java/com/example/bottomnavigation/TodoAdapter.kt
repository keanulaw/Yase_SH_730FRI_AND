package com.example.bottomnavigation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private val todoList: ArrayList<String>) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val checkBox: CheckBox = view.findViewById(R.id.checkBox)
        val todoText: TextView = view.findViewById(R.id.todoText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todoList[position]
        holder.todoText.text = todo

        holder.itemView.setOnClickListener {
            val context = it.context
            val dialogView = LayoutInflater.from(context)
                .inflate(R.layout.dialog_edit_todo, null)

            val editTodoInput = dialogView.findViewById<EditText>(R.id.editTodoInput)
            editTodoInput.setText(todo)

            AlertDialog.Builder(context)
                .setTitle("Edit Task")
                .setView(dialogView)
                .setPositiveButton("Save") { _, _ ->
                    val editedTodo = editTodoInput.text.toString()
                    todoList[position] = editedTodo
                    notifyDataSetChanged()
                }
                .setNegativeButton("Cancel", null)
                .show()
        }
    }

    override fun getItemCount(): Int = todoList.size
}
