package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Integer[] arrayImages = {
                R.drawable.land1,
                R.drawable.land2,
                R.drawable.land3,
                R.drawable.land4,
                R.drawable.land5,
                R.drawable.land6,
                R.drawable.check
        };

        final ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(arrayImages));
        final GridView grid = findViewById(R.id.grid);
        ImageAdapter imageAdapter = new ImageAdapter(this, arr);
        grid.setAdapter(imageAdapter);

        final LinearLayout mainLayout = findViewById(R.id.mainLayout);

        //TextView tv = findViewById(R.id.tv);
        //tv.setText(Integer.valueOf(arr.get(1))+"");

        /*final ListView listView = findViewById(R.id.listView);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");
        arrayList.add("Bye");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
*/
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final LayoutInflater layoutInflater = getLayoutInflater();
                final View img = layoutInflater.inflate(R.layout.imagewindow,null);
                //img.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));

                ImageView imageview = img.findViewById(R.id.img);
                imageview.setImageResource(arr.get(position));
                mainLayout.removeAllViewsInLayout();
                mainLayout.addView(img);

                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mainLayout.removeView(img);
                        mainLayout.addView(grid);
                        //mainLayout.addView(listView);
                    }
                });

            }
        });
    }
}
