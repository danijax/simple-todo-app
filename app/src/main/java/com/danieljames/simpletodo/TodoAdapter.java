package com.danieljames.simpletodo;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    private Context context;
    private List<String> items;

    public TodoAdapter(Context context, List<String> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.todo_items, null, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        holder.todoTitle.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addNewItem(String newTask){
        items.add(newTask);
        notifyItemInserted(items.size() - 1);
    }

    public void removeItem(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }


    public class TodoViewHolder extends RecyclerView.ViewHolder{

        TextView todoTitle;
        public TodoViewHolder(View itemView) {
            super(itemView);
            todoTitle = (TextView) itemView.findViewById(R.id.todoTitle);
        }
    }
}
