package com.capstone.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.capstone.todolist.R;
import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<String> todoList;

    public TodoAdapter(Context context, ArrayList<String> todoList) {
        this.context = context;
        this.todoList = todoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String currentTodo = todoList.get(position);
        holder.todoText.setText(currentTodo);

        holder.itemView.setOnClickListener(v -> {
            showEditDeleteDialog(position);
        });
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    private void showEditDeleteDialog(int position) {
        String currentTodo = todoList.get(position);

        View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_edit_todo, null);
        EditText editTodoInput = dialogView.findViewById(R.id.editTodoInput);
        editTodoInput.setText(currentTodo);

        new AlertDialog.Builder(context)
                .setTitle("Edit or Delete To-Do")
                .setView(dialogView)
                .setPositiveButton("Edit", (dialog, which) -> {
                    String updatedTodo = editTodoInput.getText().toString();
                    if (!updatedTodo.isEmpty()) {
                        todoList.set(position, updatedTodo);
                        notifyDataSetChanged();
                    }
                })
                .setNegativeButton("Delete", (dialog, which) -> {
                    todoList.remove(position);
                    notifyDataSetChanged();
                })
                .setNeutralButton("Cancel", null)
                .show();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView todoText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkBox);
            todoText = itemView.findViewById(R.id.todoText);
        }
    }
}