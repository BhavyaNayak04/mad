package com.example.a8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText num=findViewById(R.id.editText1);
        EditText msg=findViewById(R.id.editText2);
        Button btn= findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone=num.getText().toString();
                String mesg=msg.getText().toString();
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+phone));
                i.putExtra("sms_body",mesg);
                try {
                    startActivity(i);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "Permission denied",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}