package com.example.i851409.zoodirectory;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalDescriptionActivity extends AppCompatActivity {

    private int position_received;
    String title_array1[] = new String[5];
    int image_id_array1[] = new int[5];
    TextView tv3;
    TextView tv4;
    ImageView iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_description);
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

        //Setting up the title and the image resources
        Resources res = getResources();
        title_array1 = res.getStringArray(R.array.titles);

        image_id_array1[0] = R.drawable.wayne_rooney;
        image_id_array1[1] = R.drawable.anthony_martial;
        image_id_array1[2] = R.drawable.chris_smalling;
        image_id_array1[3] = R.drawable.luke_shaw;
        image_id_array1[4] = R.drawable.de_gea;

        //The description strings for each row are set up in an external source in the /res/values/strings.xml file

        //Setting up the view objects
        tv3 = (TextView) findViewById(R.id.textView3);
        iv2 = (ImageView) findViewById(R.id.imageView2);
        tv4 = (TextView) findViewById(R.id.textView4);

        //Creating the Intent object and receiving the position from the old activity
        Intent intent = getIntent();
        position_received = intent.getIntExtra(MainActivity.POSITION_ID, 20);

        //Setting up each row depending upon the position of the row received
        if(position_received == 0){
            tv3.setText(title_array1[position_received]);
            iv2.setImageResource(R.drawable.wayne_rooney);
            tv4.setText(res.getString(R.string.wr_des));
        }
        if(position_received == 1){
            tv3.setText(title_array1[position_received]);
            iv2.setImageResource(R.drawable.anthony_martial);
            tv4.setText(res.getString(R.string.am_des));
        }
        if(position_received == 2){
            tv3.setText(title_array1[position_received]);
            iv2.setImageResource(R.drawable.chris_smalling);
            tv4.setText(res.getString(R.string.cs_des));
        }
        if(position_received == 3){
            tv3.setText(title_array1[position_received]);
            iv2.setImageResource(R.drawable.luke_shaw);
            tv4.setText(res.getString(R.string.ls_des));
        }
        if(position_received == 4){
            tv3.setText(title_array1[position_received]);
            iv2.setImageResource(R.drawable.de_gea);
            tv4.setText(res.getString(R.string.dg_des));
        }
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
            Intent intent = new Intent(AnimalDescriptionActivity.this, ZooDescriptionActivity.class);
            startActivity(intent);
        }

        if(id == R.id.item2){
            Intent intent = new Intent(Intent.ACTION_DELETE);
            intent.setData(Uri.parse("package:com.example.i851409.zoodirectory"));
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }



}
