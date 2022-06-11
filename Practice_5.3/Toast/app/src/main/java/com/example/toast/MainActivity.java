package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button);
    }

    public void showToast(View view) {
        Toast toast3 = Toast.makeText(getApplicationContext(),
                "Пора смотреть гонки!", Toast.LENGTH_LONG);
        toast3.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastContainer = (LinearLayout) toast3.getView();
        ImageView carImageView = new ImageView(getApplicationContext());
        carImageView.setImageResource(R.drawable.pic);
        toastContainer.addView(carImageView, 0);
        toast3.show();
    }
}