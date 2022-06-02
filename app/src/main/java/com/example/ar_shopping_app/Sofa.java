package com.example.ar_shopping_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sofa extends AppCompatActivity {

    CardView arrow;
    Button buy;
    Button ar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sofa);

        arrow = findViewById(R.id.arrow_card);
        buy = findViewById(R.id.buy_sofa);
        ar = findViewById(R.id.arcamera_sofa);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sofa.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sofa.this, Purchased.class);
                startActivity(intent);
            }
        });

        ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sofa.this, Camera.class);
                intent.putExtra("name","sofa");
                startActivity(intent);
            }
        });
    }
}