package com.miscoriadev.svvirgoapp.util;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.miscoriadev.svvirgoapp.MainActivity;
import com.miscoriadev.svvirgoapp.R;

import java.util.ArrayList;

/**
 * Created by milanvandijck on 14/10/2016.
 */

public class UnscrollableListView extends LinearLayout{

private Context context;
private LayoutInflater inflater;
private MainActivity mainActivity;

public UnscrollableListView(Context context) {
    super(context);
    this.context = context;
    this.mainActivity = (MainActivity)context;
    this.setOrientation(LinearLayout.VERTICAL);

    if(!this.isInEditMode()) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
}

public UnscrollableListView(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.context = context;
    this.mainActivity = (MainActivity)context;
    this.setOrientation(LinearLayout.VERTICAL);

    if(!this.isInEditMode()) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
}


public void setListItems(ArrayList<ActivityItem> list){

    for (int i = 0; i <= list.size()-1; i++){
        UnscrollableListView.viewHolder holder = new UnscrollableListView.viewHolder();
        View rowView;
        final ActivityItem item = list.get(i);

        Log.d(getClass().getName(), "Adding view: " + item.getTitle());

        // Check if there are activities
        if (item.getTitle().equals("0_0") && item.getLocation().equals("0_0")){
            rowView = inflater.inflate(R.layout.activiteiten_listitem_emptylist, null);
            this.addView(rowView);
        }

        rowView = inflater.inflate(R.layout.activiteiten_listitem, null, false);

        holder.tv_name=(TextView) rowView.findViewById(R.id.eventName);
        holder.tv_date=(TextView) rowView.findViewById(R.id.eventDate);
        holder.tv_time=(TextView) rowView.findViewById(R.id.eventTime);
        holder.tv_Location= (TextView) rowView.findViewById(R.id.eventLocation);
        holder.img_poster=(ImageView) rowView.findViewById(R.id.eventPoster);

        holder.tv_name.setText(item.getTitle());
        holder.img_poster.setImageBitmap(item.getImage());
        holder.tv_date.setText(item.getDateString());
        holder.tv_time.setText(item.getTimeString());
        holder.tv_Location.setText(item.getLocation());

        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mainActivity.openActivityDetails(item);
            }
        });

        this.addView(rowView, i);
    }

    this.invalidate();

}

public class viewHolder
{
    TextView tv_name;
    TextView tv_date;
    TextView tv_time;
    TextView tv_Location;
    ImageView img_poster;
}
}