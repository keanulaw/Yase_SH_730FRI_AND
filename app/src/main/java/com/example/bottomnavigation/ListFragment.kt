package com.example.bottomnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    private var todoList = ArrayList<String>()
    private lateinit var adapter: TodoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.todoRecyclerView)
        val addButton = view.findViewById<Button>(R.id.addButton)
        val todoInput = view.findViewById<EditText>(R.id.todoInput)

        adapter = TodoAdapter(todoList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        addButton.setOnClickListener {
            val todo = todoInput.text.toString()
            if (todo.isNotEmpty()) {
                todoList.add(todo)
                adapter.notifyDataSetChanged()
                todoInput.setText("")
            }
        }

        return view
    }
}
