package com.example.memo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SetPasswordActivity extends AppCompatActivity {

    EditText passText, confirmText;
    TextView wrongPass;
    Button setPassButton;

    private TextWatcher passTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if(checkEditTexts()) {
                wrongPass.setVisibility(View.GONE);
                setPassButton.setEnabled(true);
            } else {
                wrongPass.setVisibility(View.VISIBLE);
                setPassButton.setEnabled(false);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);

        passText = findViewById(R.id.set_password_text);
        confirmText = findViewById(R.id.password_confirm_text);
        wrongPass = findViewById(R.id.wrong_pass_text);
        setPassButton = findViewById(R.id.set_password_button);

        passText.addTextChangedListener(passTextWatcher);

        confirmText.addTextChangedListener(passTextWatcher);

        setPassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Preferences.setPassword(passText.getText().toString(), getApplicationContext());
                Intent intent = new Intent(SetPasswordActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private boolean checkEditTexts() {
        return passText.getText().toString().equals(confirmText.getText().toString()) && !passText.getText().toString().isEmpty();
    }


}