package com.example.life;

import static android.content.ContentValues.TAG;
import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;

    boolean bound = false;
    ServiceConnection sConn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);

        sConn = new ServiceConnection() {
            public void onServiceConnected(ComponentName name, IBinder binder) {
                bound = true;
            }

            public void onServiceDisconnected(ComponentName name) {
                bound = false;
            }
        };

        btn1.setOnClickListener(this::startServ);
        btn2.setOnClickListener(this::bindServ);
        btn3.setOnClickListener(this::stopServ);
    }

    public void startServ(View v)
    {
        startService(new Intent(MainActivity.this, com.example.life.MyService.class));
    }

    public void bindServ(View v)
    {
        bindService(
                new Intent(MainActivity.this, com.example.life.MyService.class),
                sConn, BIND_AUTO_CREATE);
    }

    public void stopServ(View v)
    {
        stopService(new Intent(MainActivity.this, com.example.life.MyService.class));
    }
}