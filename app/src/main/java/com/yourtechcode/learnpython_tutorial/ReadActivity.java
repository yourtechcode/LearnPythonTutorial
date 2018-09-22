package com.yourtechcode.learnpython_tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.webkit.WebView;


public class ReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);


        String savedExtra = getIntent().getStringExtra("animal");

       String temp1 = savedExtra.replaceAll(" ","%20");
       String temp2 = "http://yourtechcode.com/python45/"+temp1+".html";

        WebView webView =  findViewById(R.id.webID);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);



        webView.loadUrl(temp2);





    }
}
