package com.example.ar_shopping_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    CardView table;
    CardView tv;
    CardView refrigerator;
    CardView sofa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        table =findViewById(R.id.one);
        tv =findViewById(R.id.two);
        refrigerator =findViewById(R.id.three);
        sofa =findViewById(R.id.four);

        table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Table.class);
                startActivity(intent);
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, tv.class);
                startActivity(intent);
            }
        });

        refrigerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sofa.class);
                startActivity(intent);
            }
        });

        sofa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Refrigerator.class);
                startActivity(intent);
            }
        });
    }
}