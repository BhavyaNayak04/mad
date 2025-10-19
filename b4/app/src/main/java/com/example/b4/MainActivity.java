package com.example.b4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    TextView t;
    ProgressBar pb;
    BroadcastReceiver b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        t=findViewById( R.id.textView);
        pb=findViewById( R.id.progressbar);
        b= new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
                t.setText( "Battery level:"+level );
                pb.setProgress( level );
                ConstraintLayout cl= findViewById( R.id.cl);
                if(level>60)
                {
                    cl.setBackgroundColor(Color.GREEN );
                }
                else if(level>20)
                {
                    cl.setBackgroundColor(Color.BLUE );
                }
                else
                    cl.setBackgroundColor(Color.RED );
            }
        };

    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver( b,new IntentFilter( Intent.ACTION_BATTERY_CHANGED ) );
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver( b );
    }
}