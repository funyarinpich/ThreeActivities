package com.example.threeactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.threeactivities.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    static String way = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String str = getIntent().getStringExtra("qwe");
        TextView way = findViewById(R.id.way);
        way.setText(MainActivity.way);
        binding.f12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, SecondActivity.class);
                MainActivity.way+="1";
                startActivity(intent1);
            }
        });
        binding.f13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, ThirdActivity.class);
                MainActivity.way+="1";
                startActivity(intent2);
            }
        });
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, MainActivity.class);
                switch (MainActivity.way.charAt(MainActivity.way.length()-1)){
                    case '2':
                        intent3 = new Intent(MainActivity.this, SecondActivity.class);
                        intent3.putExtra("qwe","С экрана 1 на экран 2");
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "С экрана 1 на экран 2", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case '3':
                        intent3 = new Intent(MainActivity.this, ThirdActivity.class);
                        Toast toast1 = Toast.makeText(getApplicationContext(),
                                "С экрана 1 на экран 3", Toast.LENGTH_SHORT);
                        toast1.show();
                        break;
                }
                MainActivity.way =  MainActivity.way.substring(0, MainActivity.way.length()-1);
                startActivity(intent3);
            }
        });
    }
}