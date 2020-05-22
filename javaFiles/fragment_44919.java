package com.example.simran.listviewtest;

    import android.app.Activity;
    import android.content.Context;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ArrayAdapter;
    import android.widget.TextView;

    import org.w3c.dom.Text;

    /**
     * Created by simra on 12/23/2015.
     */
    public class ArrayAdapterItem extends ArrayAdapter<ObjectItem> {
        Context mContext;
        int layoutResourceId;
        ObjectItem data[] = null;
        ArrayAdapterItemCallback callback;

        public interface ArrayAdapterItemCallback {
            updateText(String text);
        }



        public ArrayAdapterItem(Context mContext, int layoutResourceId, ObjectItem[] data, ArrayAdapterItemCallback callback) {
            super(mContext, layoutResourceId, data);

            this.layoutResourceId = layoutResourceId;
            this.mContext = mContext;
            this.data = data;
            this.callback = callback;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            /*
             * The convertView argument is essentially a "ScrapView" as described is Lucas post
             * http://lucasr.org/2012/04/05/performance-tips-for-androids-listview/
             * It will have a non-null value when ListView is asking you recycle the row layout.
             * So, when convertView is not null, you should simply update its contents instead of inflating a new row layout.
             */
            if (convertView == null) {
                // inflate the layout
                LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
                convertView = inflater.inflate(layoutResourceId, parent, false);
            }

            //trying set the text of the textView in the main_activity.
            callback.updateText("some new text");

            // object item based on the position
            ObjectItem objectItem = data[position];

            // this sets the text and tag for the item in the list. Works fine
            TextView textViewItem = (TextView)   convertView.findViewById(R.id.textViewItem);
            textViewItem.setText(objectItem.itemName);
            textViewItem.setTag(objectItem.itemId);

            return convertView;

        }
    }