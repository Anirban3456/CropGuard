package com.example.cropguard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class CropSelectActivity extends AppCompatActivity {

    //private ImageButton backButton;
    private ImageButton soyaBeanImageView;
    private ImageButton carrotImageView;
    private ImageButton spinachImageView;
    private ImageButton cabbageImageView;
    private ImageButton appleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cropselection); // Make sure this is the correct layout name

        // Initialize views
        //backButton = findViewById(R.id.backButton);
        soyaBeanImageView = findViewById(R.id.soyaBeanImageView);
        carrotImageView = findViewById(R.id.carrotImageView);
        spinachImageView = findViewById(R.id.spinachImageView);
        cabbageImageView = findViewById(R.id.cabbageImageView);
        appleImageView = findViewById(R.id.appleImageView);

        // Set OnClickListener for the back button
        //backButton.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {
                // Go back to the LoginActivity
               // Intent intent = new Intent(CropSelectActivity.this, LoginActivity.class);
               // startActivity(intent);
               // finish(); // Optional: Close CropSelectActivity after navigating
           // }
        //});

        // Set OnClickListener for Soya Bean
        soyaBeanImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to the Camera Activity
                Intent intent = new Intent(CropSelectActivity.this, CameraActivity.class); // Replace CameraActivity with your actual camera activity
                startActivity(intent);
            }
        });

        // Set OnClickListener for other crops (show a toast message)
        View.OnClickListener otherCropClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CropSelectActivity.this, "Currently in Development...", Toast.LENGTH_SHORT).show();
            }
        };

        carrotImageView.setOnClickListener(otherCropClickListener);
        spinachImageView.setOnClickListener(otherCropClickListener);
        cabbageImageView.setOnClickListener(otherCropClickListener);
        appleImageView.setOnClickListener(otherCropClickListener);
    }
}