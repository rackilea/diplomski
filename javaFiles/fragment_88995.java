package com.ds.listviewtest;

import android.app.ListActivity;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    static final String[] FRUITS = new String[] {
            "Apple", "Avocado", "Banana",
            "Blueberry", "Coconut", "Durian", "Guava", "Kiwifruit",
            "Jackfruit", "Mango", "Olive", "Pear", "Sugar-apple"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setListAdapter(new SimpleAdapter(FRUITS));
        setContentView(R.layout.activity_main);
    }

    private class SimpleAdapter implements ListAdapter
    {
        String[] items;

        public SimpleAdapter(String[] items)
        {
            this.items = items;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver observer) {
            // TODO Auto-generated method stub

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {
            // TODO Auto-generated method stub

        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return items.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return items[position];
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public boolean hasStableIds() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.list_item, parent, false);
            TextView textView = (TextView) rowView.findViewById(R.id.comment);
            textView.setText(items[position]);

            return rowView;
        }

        @Override
        public int getItemViewType(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int getViewTypeCount() {
            // TODO Auto-generated method stub
            return 1;
        }

        @Override
        public boolean isEmpty() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean areAllItemsEnabled() {
            // TODO Auto-generated method stub
            return true;
        }

        @Override
        public boolean isEnabled(int position) {
            // TODO Auto-generated method stub
            return true;
        }

    }

}