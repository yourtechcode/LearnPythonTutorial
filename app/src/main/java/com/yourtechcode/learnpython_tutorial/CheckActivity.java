package com.yourtechcode.learnpython_tutorial;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        Button btn = findViewById(R.id.retryButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (InternetActivity.getInstance(getApplicationContext()).isOnline()) {

                    /**
                     * Internet is available, Toast It!
                     */
                    Toast.makeText(getApplicationContext(), "WiFi/Mobile Networks Connected!", Toast.LENGTH_SHORT).show();

                    new Handler().postDelayed(new Runnable() {


// Using handler with postDelayed called runnable run method

                        @Override

                        public void run() {

                            Intent i = new Intent(CheckActivity.this, MenuActivity.class);

                            startActivity(i);

                            // close this activity

                            finish();

                        }

                    }, 1); //
                } else {
                    /**
                     * Internet is NOT available, Toast It!
                     */

                    Toast.makeText(getApplicationContext(), "Ooops! No WiFi/Mobile Networks Connected!", Toast.LENGTH_SHORT).show();


                }

            }
        });
    }
}
