package com.example.memo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.memo.data.MemoryData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MemoryActivity extends AppCompatActivity {

    TextView titleText, descriptionText;
    FloatingActionButton shareButton, editButton;

    MemoryData memoryData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        Bundle extras = getIntent().getExtras();

        memoryData = MainActivity.memoryList.get(extras.getInt("memoryPosition"));

        titleText = findViewById(R.id.memory_title_text);
        descriptionText = findViewById(R.id.memory_description_text);
        shareButton = findViewById(R.id.memory_share_button);
        editButton = findViewById(R.id.memory_edit_button);

        titleText.setText(memoryData.getName());
        descriptionText.setText(memoryData.getDescription());

        editButton.setOnClickListener(view -> {
            Intent switchEditMemoryActivity = new Intent(this, MemoryEditActivity.class);
            switchEditMemoryActivity.putExtra("memoryPosition", extras.getInt("memoryPosition"));
            startActivity(switchEditMemoryActivity);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        titleText.setText(memoryData.getName());
        descriptionText.setText(memoryData.getDescription());
    }
}