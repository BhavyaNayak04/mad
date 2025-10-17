package com.example.a7;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText num= findViewById(R.id.et);
        Button call= findViewById(R.id.button);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number=num.getText().toString();
                Intent callintent=new Intent(Intent.ACTION_CALL);
                callintent.setData(Uri.parse("tel:"+number));
                try {
                    startActivity(callintent);
                }catch (Exception e){
                    Log.d("error",e.getMessage());
                    Log.d("error",e.getMessage());
                    Toast.makeText(getApplicationContext(),"call permission denied",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}