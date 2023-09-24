package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declare UI elements
    private EditText edtEmail, edtPassword;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_pass);
        tvResult = findViewById(R.id.tv_result);
        Button btnLogin = findViewById(R.id.btn_login);

        // Set a click listener for the login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                // Get the text entered in the email and password fields
                String enteredEmail = edtEmail.getText().toString().trim();
                String enteredPassword = edtPassword.getText().toString();

                // Check if the entered email and password are valid
                if (isValidCredentials(enteredEmail, enteredPassword)) {
                    // Display a success message if credentials are valid
                    tvResult.setText("LOGIN SUCCESS!");
                } else {
                    // Display a failure message if credentials are invalid
                    tvResult.setText("LOGIN FAILED");
                }
            }
        });
    }

    // Validate login credentials
    private boolean isValidCredentials(String email, String password) {
        // In a real app, I would validate against a backend or a database
        // For this example, we use hardcoded valid credentials
        return email.equalsIgnoreCase("validemail@gmail.com") && password.equals("valid123");
    }
}
