package com.yourtechcode.learnpython_tutorial;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    String[] nameArray = {"Overview","Enviroment Setup","Basic Syntax","Variable Types","Basic Operators","Decision Making","Loops","Numbers","Strings","Lists","Tuples","Dictionary","Date and Time","Function","Modules","Files IO","Exceptions","Classes and Objects","Reg Expression","CGI Programming","Database Access","Networking","Sending Email","Multithreading","XML Processing","GUI Programming","Further Extension"};
    Integer[] imageArray = {R.drawable.overview,R.drawable.enviroment,R.drawable.syntax,R.drawable.variable,R.drawable.operators,R.drawable.decision,R.drawable.loop,R.drawable.numbers,R.drawable.strings,R.drawable.lists,R.drawable.tuple,R.drawable.dictionary,R.drawable.date,R.drawable.functions,R.drawable.module,R.drawable.files,R.drawable.exceptionshandling,R.drawable.object,R.drawable.expression,R.drawable.cgi,R.drawable.sql,R.drawable.network,R.drawable.email,R.drawable.multithread,R.drawable.xml,R.drawable.gui,R.drawable.extension};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        CustomListAdapter whatever = new CustomListAdapter(this, nameArray, imageArray);

        listView = (ListView) findViewById(R.id.listViewId);
        listView.setAdapter(whatever);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

//                Intent intent = new Intent(MenuActivity.this, ReadActivity.class);
//                String message = nameArray[position];
//                intent.putExtra("animal", message);
//                startActivity(intent);
                if (InternetActivity.getInstance(getApplicationContext()).isOnline()) {
                    /**
                     * Internet is available, Toast It!
                     */
                    Intent intent = new Intent(MenuActivity.this, ReadActivity.class);
                    String message = nameArray[position];
                    intent.putExtra("animal", message);
                    startActivity(intent);



                } else {
                    /**
                     * Internet is NOT available, Toast It!
                     */
                    Toast.makeText(getApplicationContext(), "Ooops! No WiFi/Mobile Networks Connected!", Toast.LENGTH_SHORT).show();
                }

            }


        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.rateUs){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.yourtechcode.learnpython_tutorial"));
            startActivity(intent);
        }
        else if(item.getItemId()==R.id.share){
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "YourTechCode");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Now Learn Python easily https://play.google.com/store/apps/details?id=com.yourtechcode.learnpython_tutorial");
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        }
        else if(item.getItemId()==R.id.contact){
            try{Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "yourtechcode95@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "A user from Learn Python App");
            intent.putExtra(Intent.EXTRA_TEXT, "Hey Amit,");
            startActivity(intent);}
            catch(ActivityNotFoundException e){
                //TODO smth
                Toast.makeText(getApplicationContext(),"Can't find GMail App. Please install or update it to new version",Toast.LENGTH_SHORT).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}


