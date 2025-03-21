package com.example.cropguard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;

    //private ImageButton backButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        //backButton1 = findViewById(R.id.backButton1);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // For now, just proceed to the next activity without any validation
                // In a real app, you would validate the email and password here

                // Show a toast message (optional)
                Toast.makeText(LoginActivity.this, "Logging in...", Toast.LENGTH_SHORT).show();

                // Start the next activity
                Intent intent = new Intent(LoginActivity.this, CropSelectActivity.class);
                startActivity(intent);
            }
        });

        //backButton1.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {
                // Go back to the Instructions Activity
                //Intent intent = new Intent(LoginActivity.this, InstructionActivity.class);
                //startActivity(intent);
                //finish(); // Optional: Close LoginActivity after navigating
            //}
        //});
    }
}