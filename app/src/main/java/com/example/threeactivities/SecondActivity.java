package com.example.threeactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.threeactivities.databinding.ActivityMain2Binding;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMain2Binding binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String str = getIntent().getStringExtra("qwe");
        TextView way = findViewById(R.id.way);
        way.setText(MainActivity.way);
        binding.f21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                MainActivity.way+="2";
                startActivity(intent);
            }
        });
        binding.f23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                MainActivity.way+="2";
                startActivity(intent);
            }
        });
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(SecondActivity.this, MainActivity.class);
                switch (MainActivity.way.charAt(MainActivity.way.length()-1)){
                    case '1':
                        intent3 = new Intent(SecondActivity.this, MainActivity.class);
                        Toast toast1 = Toast.makeText(getApplicationContext(),
                                "С экрана 2 на экран 1", Toast.LENGTH_SHORT);
                        toast1.show();
                        break;
                    case '3':
                        intent3 = new Intent(SecondActivity.this, ThirdActivity.class);
                        Toast toast2 = Toast.makeText(getApplicationContext(),
                                "С экрана 2 на экран 3", Toast.LENGTH_SHORT);
                        toast2.show();
                        break;
                }
                MainActivity.way =  MainActivity.way.substring(0, MainActivity.way.length()-1);
                startActivity(intent3);
            }
        });
    }
}