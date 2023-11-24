package com.example.threeactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.threeactivities.databinding.ActivityMain3Binding;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMain3Binding binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String str = getIntent().getStringExtra("qwe");
        TextView way = findViewById(R.id.way);
        way.setText(MainActivity.way);
        binding.f31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                MainActivity.way+="3";
                startActivity(intent);
            }
        });
        binding.f32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                MainActivity.way+="3";
                startActivity(intent);
            }
        });
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(ThirdActivity.this, MainActivity.class);
                switch (MainActivity.way.charAt(MainActivity.way.length()-1)){
                    case '1':
                        intent3 = new Intent(ThirdActivity.this, MainActivity.class);
                        Toast toast1 = Toast.makeText(getApplicationContext(),
                                "С экрана 3 на экран 1", Toast.LENGTH_SHORT);
                        toast1.show();
                        break;
                    case '2':
                        intent3 = new Intent(ThirdActivity.this, SecondActivity.class);
                        Toast toast2 = Toast.makeText(getApplicationContext(),
                                "С экрана 3 на экран 2", Toast.LENGTH_SHORT);
                        toast2.show();
                        break;
                }
                MainActivity.way =  MainActivity.way.substring(0, MainActivity.way.length()-1);
                startActivity(intent3);
            }
        });
    }
}