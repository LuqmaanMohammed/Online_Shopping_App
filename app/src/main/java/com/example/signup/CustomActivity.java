package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CustomActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        FloatingActionButton cartButton = findViewById(R.id.cartButton);
        cartButton.setOnClickListener(v -> Toast.makeText(CustomActivity.this, "1 Item added to cart", Toast.LENGTH_SHORT).show());

        }
    }