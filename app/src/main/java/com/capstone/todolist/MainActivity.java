package com.capstone.todolist;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> todoList;
    private TodoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoList = new ArrayList<>();
        RecyclerView todoListView = findViewById(R.id.todoListView);
        TextInputEditText todoInput = findViewById(R.id.todoInput);
        Button addButton = findViewById(R.id.addButton);

        adapter = new TodoAdapter(this, todoList);
        todoListView.setLayoutManager(new LinearLayoutManager(this));
        todoListView.setAdapter(adapter);

        addButton.setOnClickListener(view -> {
            String todo = todoInput.getText().toString();
            if (!todo.isEmpty()) {
                todoList.add(todo);
                adapter.notifyDataSetChanged();
                todoInput.setText("");
            }
        });
    }
}