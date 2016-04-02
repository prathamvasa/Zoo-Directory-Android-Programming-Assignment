package com.example.i851409.zoodirectory;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    String title_array[]= new String[5];
    int image_id_array[]= new int[5];
    ListView listView;
    public final static String POSITION_ID = "com.example.i851409.zoodirectory.position_id";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        //Fetching the values from the string-array and assigning it to the above created String array
        Resources res = getResources();
        title_array = res.getStringArray(R.array.titles);

        //Creating an array of image ids
        image_id_array[0] = R.drawable.wayne_rooney;
        image_id_array[1] = R.drawable.anthony_martial;
        image_id_array[2] = R.drawable.chris_smalling;
        image_id_array[3] = R.drawable.luke_shaw;
        image_id_array[4] = R.drawable.de_gea;

        //Instantiating the ListView object and fetching it to the code
        listView = (ListView) findViewById(R.id.listView1);

        //Instantiating the Customized Adapter
        MyCustomAdapter mca = new MyCustomAdapter(this, title_array, image_id_array);
        listView.setAdapter(mca);

        //Setting the listener to the individual items of the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String tmp_str = (String) listView.getItemAtPosition(position);
                //Toast.makeText(getApplicationContext(), "Text is: "+tmp_str+" at position: "+position, Toast.LENGTH_SHORT).show();



                //Checking the conditions to create the Dialog Box with the alert message
                if(position!=4){
                    //Building an Intent object to start another activity
                    Intent intent = new Intent(MainActivity.this, AnimalDescriptionActivity.class);

                    //Passing the position of the row selected to another activity
                    intent.putExtra(POSITION_ID, position);
                    startActivity(intent);
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle(R.string.ab_title);
                    builder.setIcon(R.drawable.ab_icon);
                    builder.setMessage(R.string.ab_messgae)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int id) {
                                    //Go to the next activity
                                    //Building an Intent object to start another activity
                                    Intent intent = new Intent(MainActivity.this, AnimalDescriptionActivity.class);

                                    //Passing the position of the row selected to another activity
                                    intent.putExtra(POSITION_ID, 4);
                                    startActivity(intent);
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //Do nothing and stay on the same activity
                                }
                            });
                    // Create the AlertDialog object and return it
                    builder.create();
                    builder.show();
                }

            }
        });
    }

    @Override
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
            Intent intent = new Intent(MainActivity.this, ZooDescriptionActivity.class);
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

//Class implementation for the Customized Adapter
class MyCustomAdapter extends ArrayAdapter<String>{
    Context context;
    int images[];
    String tls[];
    MyCustomAdapter(Context c, String[] titles, int img[]){
        super(c, R.layout.customized_listview, R.id.textView2, titles);
        this.context = c;
        this.images = img;
        this.tls = titles;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.customized_listview, parent, false);

        //Setting the background color of the row
        if(position%2==0) {
            row.setBackgroundColor(Color.LTGRAY);
        }
        else{
            row.setBackgroundColor(Color.DKGRAY);
        }

        //Getting the reference to the TextView and the ImageView
        ImageView iv = (ImageView) row.findViewById(R.id.imageView);
        TextView tv = (TextView) row.findViewById(R.id.textView2);

        //Populating the ImageView and the TextView with appropriate data
        iv.setImageResource(images[position]);
        tv.setText(tls[position]);

        return row;
    }

}
