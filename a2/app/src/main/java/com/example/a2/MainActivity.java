package com.example.a2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        CheckBox cb1 = findViewById(R.id.cb1);
        CheckBox cb2 = findViewById(R.id.cb2);
        CheckBox cb3 = findViewById(R.id.cb3);
        CheckBox cb4 = findViewById(R.id.cb4);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int total = 0;
                StringBuilder s = new StringBuilder();
                if(cb1.isChecked()){
                    s.append("\nRice\t:\tRs.100");
                    total+=100;
                }
                if(cb2.isChecked()){
                    s.append("\nWheat\t:\tRs.50");
                    total+=50;
                }
                if(cb3.isChecked()){
                    s.append("\nCake\t:\tRs.400");
                    total+=400;
                }
                if(cb4.isChecked()){
                    s.append("\nBread\t:\tRs.150");
                    total+=150;
                }
                s.append("\nTotal:-\t Rs.").append(total).append("/-");
                Toast.makeText(getApplicationContext(), s.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}