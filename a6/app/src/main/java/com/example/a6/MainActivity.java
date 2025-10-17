package com.example.a6;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1= findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder b=new AlertDialog.Builder(MainActivity.this);
                b.setTitle("BackGround Color Changer");
                b.setMessage("Are you sure you want to change the color");
                b.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ConstraintLayout r=findViewById(R.id.cl);
                        Random gen=new Random();

                        r.setBackgroundColor(Color.rgb(gen.nextInt(256),gen.nextInt(100),gen.nextInt(100)));
                    }
                });
                b.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                b.show();


            }
        });
    }
}