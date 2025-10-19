package com.example.b3;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ProgressBar pb;
    TextView count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        pb = findViewById(R.id.progressbar);
        pb.setMax(1000);
        Button start =  findViewById(R.id.button);
        count =  findViewById(R.id.textView);
        start.setOnClickListener(this);
    }
    class T extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... strings) {
            int max = Integer.parseInt(strings[0]);
            int i = 0;
            while (i < max) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                publishProgress(i);
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            pb.setProgress(values[0]);
            count.setText(values[0].toString());
            super.onProgressUpdate();
        }
    }


    @Override
    public void onClick(View view) {
        T t = new T();
        t.execute("1000");

    }
}