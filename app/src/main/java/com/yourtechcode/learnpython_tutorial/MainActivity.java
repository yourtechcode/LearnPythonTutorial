package com.yourtechcode.learnpython_tutorial;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(MainActivity.this, CheckActivity.class);
        if (InternetActivity.getInstance(getApplicationContext()).isOnline()) {

            /**
             * Internet is available, Toast It!
             */
            //Toast.makeText(getApplicationContext(), "WiFi/Mobile Networks Connected!", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {


// Using handler with postDelayed called runnable run method

                @Override

                public void run() {

                    Intent i = new Intent(MainActivity.this, MenuActivity.class);

                    startActivity(i);

                    // close this activity

                    finish();

                }

            }, 2*1000); //
        } else {
            /**
             * Internet is NOT available, Toast It!
             */
            startActivity(i);
            Toast.makeText(getApplicationContext(), "Ooops! No WiFi/Mobile Networks Connected!", Toast.LENGTH_SHORT).show();


            }

}
}
