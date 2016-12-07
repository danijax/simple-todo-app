package com.danieljames.simpletodo;

import android.graphics.Canvas;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TodoAdapter todoAdapter;
    private List<String> todos;
    private TextView newTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        newTask = (TextView) findViewById(R.id.editText);
        todos = new ArrayList<>();
        todos.add("First Task");
        todos.add("Second Task");
        todos.add("Third Task");
        todos.add("Fourth Task");
        todos.add("Fifth Task");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        todoAdapter = new TodoAdapter(this, todos);
        recyclerView.setAdapter(todoAdapter);
        recyclerView.addOnItemTouchListener(new TodoRecyclerViewTouchListener(this, recyclerView, new TodoRecyclerViewTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                //todoAdapter.removeItem(position);
                Toast.makeText(MainActivity.this, "Single Click on position        :"+position,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Single Click on position        :"+position,
                        Toast.LENGTH_SHORT).show();
                todoAdapter.removeItem(position);

            }
        }));

    }

    public void onAddItem(View view){
        String newText = newTask.getText().toString().trim();
        if (newText.equals("") || newText == null){
            //Snackbar.make()
        }
        todoAdapter.addNewItem(newText);


    }
}
