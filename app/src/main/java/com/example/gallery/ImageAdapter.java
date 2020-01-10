package com.example.gallery;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    ArrayList<Integer> arrayList;
    Context c;
    public ImageAdapter(Context context, ArrayList<Integer> array) {
        arrayList = array;
        c = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView image = new ImageView(c);
        image.setLayoutParams(new GridView.LayoutParams(200, 200));
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        image.setPadding(0, 8, 0, 8);
        image.setImageResource(arrayList.get(position));
        Log.i("Hello", "Done"+ arrayList.get(position));
        return image;
    }
}
