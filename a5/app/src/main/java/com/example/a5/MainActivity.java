package com.example.a5;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
    EditText f;
    EditText s;
    TextView result;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button clear;
    ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        f=findViewById(R.id.t1);
        s=findViewById(R.id.t2);
        result=findViewById(R.id.t3);
        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);
        btn3=findViewById(R.id.button3);
        btn4=findViewById(R.id.button4);
        clear=findViewById(R.id.button5);
        cl=findViewById(R.id.cl);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editing1=f.getText().toString();
                String editing2=s.getText().toString();
                int n1=Integer.parseInt(editing1);
                int n2=Integer.parseInt(editing2);
                int sum=n1+n2;
                result.setText("Sum is "+sum);
                result.setTextColor(Color.parseColor("#A10404"));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editing1=f.getText().toString();
                String editing2=s.getText().toString();
                int n1=Integer.parseInt(editing1);
                int n2=Integer.parseInt(editing2);
                int diA=n1-n2;
                result.setText("DiAerence is "+diA);
                result.setTextColor(Color.parseColor("#4CAF50"));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editing1=f.getText().toString();
                String editing2=s.getText().toString();
                int n1=Integer.parseInt(editing1);
                int n2=Integer.parseInt(editing2);
                int prod=n1*n2;
                result.setText("Product is "+prod);
                result.setTextColor(Color.parseColor("#2196F3"));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editing1=f.getText().toString();
                String editing2=s.getText().toString();
                int n1=Integer.parseInt(editing1);
                int n2=Integer.parseInt(editing2);
                int q=n1/n2;
                result.setText("Quotient is "+q);
                result.setTextColor(Color.parseColor("#E1789C"));
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f.setText("0");
                s.setText("0");
                result.setText("0");
                Random r=new Random();
                cl.setBackgroundColor(Color.rgb(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
            }
        });
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r=new Random();
                cl.setBackgroundColor(Color.rgb(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
            }
        });
    }
}