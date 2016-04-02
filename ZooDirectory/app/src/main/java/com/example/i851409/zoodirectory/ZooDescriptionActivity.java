package com.example.i851409.zoodirectory;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ZooDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button btnx = (Button) findViewById(R.id.button);
        btnx.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                String resd = "tel:888-8888";
                Intent myintent = new Intent(Intent.ACTION_DIAL, Uri.parse(resd));
                startActivity(myintent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.customized_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //Fetching the ids of the menu items from the action bar
        if (id == R.id.item1) {

            //Building an Intent object to start another activity
            Intent intent = new Intent(ZooDescriptionActivity.this, ZooDescriptionActivity.class);
            startActivity(intent);
        }

        if (id == R.id.item2) {
            Intent intent = new Intent(Intent.ACTION_DELETE);
            intent.setData(Uri.parse("package:com.example.i851409.zoodirectory"));
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }



}
