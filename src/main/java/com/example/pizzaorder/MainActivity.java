package com.example.pizzaorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveName(View view) {
        TextView name = findViewById(R.id.editTextTextPersonName);
        String userName = name.getText().toString();
        Intent in = new Intent(MainActivity.this, MainActivity2.class);
        in.putExtra("userName", userName);
        startActivity(in);
    }
}