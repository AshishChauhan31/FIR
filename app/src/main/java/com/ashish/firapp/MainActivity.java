package com.ashish.firapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button policeBtn,victimBtn,reportBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        policeBtn=findViewById(R.id.btnPolice);
        victimBtn=findViewById(R.id.btnVictim);
        reportBtn=findViewById(R.id.btnReport);

        policeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,PoliceLogin.class);
                startActivity(intent);

            }
        });

        victimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,VictimLogin.class);
                startActivity(intent);


            }
        });

        reportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ReportsActivity.class);
                startActivity(intent);


            }
        });
    }
}
