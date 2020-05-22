package org.iimed.www;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
 import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ImageTextListViewActivity extends Activity implements OnItemClickListener {

public static final String[] titles = new String[] { "Penicillins",
    "Cephalosporins", "Monobactams",      "Carbapenems","Macrolides","Tetracyclines",};

public static final String[] descriptions = new String[] {
    "It is an aggregate accessory fruit",
    "It is the largest herbaceous flowering plant", "Citrus Fruit",
    "Mixed Fruits","none","none" };

public static final Integer[] images = { R.drawable.antibiotic_buton,
    R.drawable.antibiotic_buton, R.drawable.antibiotic_buton,   R.drawable.antibiotic_buton, R.drawable.antibiotic_buton,R.drawable.antibiotic_buton, };

ListView listView;
List<Object> rowItems;


@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.screj);

    rowItems = new ArrayList<Object>();
    for (int i = 0; i < titles.length; i++) {
        Object item = new Object();
        rowItems.add(item);
    }

    listView = (ListView) findViewById(R.id.list);
    ListAdapter adapter = new ListAdapter(this,R.layout.list_item, rowItems);
    listView.setAdapter(adapter);
    listView.setOnItemClickListener(this);
}

public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
    // TODO Auto-generated method stub
    Intent intent = null ;
    switch (arg2) {
    case 0:
        intent  = new Intent(ImageTextListViewActivity.this, MainActivity.class);
        startActivity(intent);          
        break;
    case 1:
        intent = new Intent(ImageTextListViewActivity.this, Miipet.class);
        startActivity(intent);
        break;
    default:
        break;
    }
}
}