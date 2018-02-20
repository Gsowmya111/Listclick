package com.example.root.listclick;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    int prev,now;
    ListView listView;


    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] flags = new int[]{
            R.drawable.ac01,
            R.drawable.rgb01,
            R.drawable.sprinkler01,
            R.drawable.bell01,
            R.drawable.dimer01,
            R.drawable.dog01,
            R.drawable.lock01,
            R.drawable.pir01,
            R.drawable.switch_board01,

    };


    int[] flags12 = new int[]{
            R.drawable.ac01,
            R.drawable.rgb01,
            R.drawable.sprinkler01,
            R.drawable.bell01,
            R.drawable.dimer01,
            R.drawable.dog01,
            R.drawable.lock01,
            R.drawable.pir01,
            R.drawable.switch_board01,


    };

    int[] flags13 = new int[]{

            R.drawable.ac02,
            R.drawable.rgb02,
            R.drawable.sprinkler02,
            R.drawable.bell02,
            R.drawable.dimer02,
            R.drawable.dog02,
            R.drawable.lock02,
            R.drawable.pir02,
            R.drawable.switch_board02,

    };




    List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

    HashMap<String, String> hm,hm2;

    SimpleAdapter adapter,adapter2;



    View view1;
    ImageView previmage;
    int test=0;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Each row in the list stores country name, currency and flag
       // List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<9;i++){
            hm = new HashMap<String,String>();
          //  hm.put("txt", "Country : " + countries[i]);
           // hm.put("cur","Currency : " + currency[i]);
            hm.put("flag", Integer.toString(flags[i]) );
            aList.add(hm);

        }


        // Keys used in Hashmap
        String[] from = { "flag","txt","cur" };

        // Ids of views in listview_layout
        int[] to = { R.id.flag,R.id.txt,R.id.cur};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_layout, from, to);

        // Getting a reference to listview of main.xml layout file
         listView = ( ListView ) findViewById(R.id.listview);

        // Setting the adapter to the listView
        listView.setAdapter(adapter);

        if(prev>0)
        {
            hm.put("flag",Integer.toString(flags[9]));
            previmage.setImageResource(R.drawable.india);
        }




        listView.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                view.setBackgroundColor(0x0000FF00);
                Toast.makeText(MainActivity.this, "Position=" + position, Toast.LENGTH_SHORT).show();

                if(test!=0)
                    previmage.setImageResource(R.drawable.srilanka);
                test++;


                ImageView imageView = (ImageView) view.findViewById(R.id.flag);
                imageView.setImageResource(R.drawable.india);

                previmage=imageView;
                now=position;

                String[] from = { "flag","txt","cur" };

                aList.clear();
                listView.setAdapter(null);
                List<HashMap<String,String>> aList2 = new ArrayList<HashMap<String,String>>();
                aList2.clear();
                // Ids of views in listview_layout
                int[] to = { R.id.flag,R.id.txt,R.id.cur};
                //imageView.setImageResource(R.drawable.india);
                adapter2 = new SimpleAdapter(getBaseContext(), aList2, R.layout.listview_layout, from, to);
                for(int j=0;j<9;j++){

                    hm2 = new HashMap<String,String>();

                    if(now==j)
                    {
                       // hm2.put("txt", "Country : " + countries[j]);
                       // hm2.put("cur", "Currency : " + currency[j]);
                        hm2.put("flag", Integer.toString(flags13[j]));
                    }
                    else {
                      //  hm2.put("txt", "Country : " + countries[j]);
                       // hm2.put("cur", "Currency : " + currency[j]);
                        hm2.put("flag", Integer.toString(flags12[j]));
                    }
                    aList2.add(hm2);

                }



                listView.setAdapter(adapter2);
                prev=position;
               // parent.getId()
                /*for(int i=0;i<20;i++){
                    hm = new HashMap<String,String>();
                    hm.put("txt", "Country : " + countries[i]);
                    hm.put("cur","Currency : " + currency[i]);
                    hm.put("flag", Integer.toString(flags[i]) );
                    aList.add(hm);
                }*/
               // hm.put("flag", Integer.toString(flags[position]) );
               // aList.add(hm);
                //TextView im=(TextView) view;
                //ImageView im=(ImageView) convertView.view;
               // im.setText("selected");
            }
        });

        if(prev>0)
        {
            hm.put("flag",Integer.toString(flags[9]));
            previmage.setImageResource(R.drawable.india);
        }
    }

}