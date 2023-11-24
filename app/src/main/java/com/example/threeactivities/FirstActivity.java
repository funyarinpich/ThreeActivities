package com.example.threeactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.threeactivities.databinding.ActivityMain1Binding;

public class FirstActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMain1Binding binding = ActivityMain1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.f12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(FirstActivity.this, SecondActivity.class);
                intent1.putExtra("qwe", "1 3");
                startActivity(intent1);
            }
        });
        binding.f13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(FirstActivity.this, ThirdActivity.class);
                intent2.putExtra("qwe", "1 3");
                startActivity(intent2);
            }
        });
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = getIntent().getStringExtra("qwe");
            }
        });
    }
}