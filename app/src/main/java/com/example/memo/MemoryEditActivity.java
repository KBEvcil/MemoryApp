package com.example.memo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.memo.data.MemoryData;

public class MemoryEditActivity extends AppCompatActivity {

    EditText nameEditText, descriptionEditText;
    Button cancelButton, saveButton;

    MemoryData memoryData;

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_edit);

        extras = getIntent().getExtras();

        nameEditText = findViewById(R.id.memory_name_editText);
        descriptionEditText = findViewById(R.id.memory_description_editText);
        cancelButton = findViewById(R.id.memory_edit_cancel_button);
        saveButton = findViewById(R.id.memory_edit_save_button);

        memoryData = MainActivity.memoryList.get(extras.getInt("memoryPosition"));

        nameEditText.setText(memoryData.getName());
        descriptionEditText.setText(memoryData.getDescription());

        saveButton.setOnClickListener(view -> {
            memoryData.setName(nameEditText.getText().toString());
            memoryData.setDescription(descriptionEditText.getText().toString());
            finish();
        });
        cancelButton.setOnClickListener(view -> {
            finish();
        });

    }
}