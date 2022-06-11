package com.example.memo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.memo.data.MemoryData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton addMemoryButton;
    RecyclerView memoryRecyclerView;

    MemoryAdapter mAdapter;

    public static ArrayList<MemoryData> memoryList;

    String tmpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addMemoryButton = findViewById(R.id.add_memory_button);
        memoryRecyclerView = findViewById(R.id.memory_recycle_view);

        memoryList = new ArrayList<>();
        memoryList.add(new MemoryData("Agalarla Tatil"));
        memoryList.add(new MemoryData("Ailem"));
        memoryList.add(new MemoryData("Unutulmaz"));
        memoryList.add(new MemoryData("Konser"));
        memoryList.add(new MemoryData("Dünyanın En İyi Müzesi"));

        mAdapter = new MemoryAdapter(this, memoryList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);

        memoryRecyclerView.setLayoutManager(gridLayoutManager);
        memoryRecyclerView.setAdapter(mAdapter);

        addMemoryButton.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            final EditText nameInput = new EditText(this);
            builder.setView(nameInput);
            builder.setTitle("Please Enter the Memory Name");
            builder.setPositiveButton("ADD", (dialogInterface, i) -> {
                memoryList.add(new MemoryData(nameInput.getText().toString()));
                mAdapter.notifyItemInserted(memoryList.size()-1);
                Toast.makeText(MainActivity.this, "Memory added.", Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();
            });
            builder.setNegativeButton("CANCEL", (dialogInterface, i) -> {
                dialogInterface.cancel();
            });
            builder.show();
        });

    }

}