package com.ashish.firapp;
import android.widget.Button;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class VictimOptions extends AppCompatActivity {

    private Button newReport,viewReport,cancelReport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victim_options);

        newReport=findViewById(R.id.btnNewReport);
        viewReport=findViewById(R.id.btnViewReport);
        cancelReport=findViewById(R.id.btnCancelReport);
        newReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(VictimOptions.this,WriteNewReport.class);
                startActivity(intent);

            }
        });

        viewReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(VictimOptions.this,ExistingReport.class);
                startActivity(intent);

            }
        });

        cancelReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(VictimOptions.this,CancelReport.class);
                startActivity(intent);

            }
        });

    }
}
