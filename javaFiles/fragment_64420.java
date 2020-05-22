package com.example.alex.documentupload;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Map;

public class ExtendedAdaptor extends SimpleAdapter {

    public static Context NewContext;

    public ExtendedAdaptor(Context context, List<? extends Map<String, ?>> data, int     resource, String[] from, int[] to){
        super(context, data, resource, from, to);
        NewContext = context;
    }

    public View getView(int position, View convertView, ViewGroup parent){


        // here you let SimpleAdapter built the view normally.
        View v = super.getView(position, convertView, parent);

        // Then we get reference for Picasso
        ImageView img = (ImageView) v.getTag();
        if(img == null){
            img = (ImageView) v.findViewById(R.id.img);
            v.setTag(img); // <<< THIS LINE !!!!
        }
        // get the url from the data you passed to the `Map`
        String url = ((Map)getItem(position)).get("path").toString();
        // do Picasso
        // maybe you could do that by using many ways to start



        Picasso.with(NewContext).load(url)
                .resize(100, 100).into(img);

        // return the view
        return v;
    }
}