package com.example.jsonparser;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.RecyclerListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends BaseAdapter {

    private static final String TAG = "Adapter";
    private Activity mActivity;
    public ArrayList<Data> mObjects;

    static class ViewHolder {
        ImageView icon;
        TextView title;
        DownloadImageTask mTask;
    }

    public Adapter(Activity activity, ArrayList<Data> mObjects) {

        this.mActivity = (Activity) activity;
        this.mObjects = mObjects;
    }

    public void setObjects(ArrayList<Data> mObjects) {
        this.mObjects = mObjects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Data item = mObjects.get(position);
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            rowView = inflater.inflate(R.layout.item, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.icon = (ImageView) rowView.findViewById(R.id.image);
            viewHolder.title = (TextView) rowView.findViewById(R.id.title);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();

        holder.title.setText(item.getmTitle());
        holder.icon.setBackgroundResource(R.drawable.ic_launcher);
        holder.mTask = new DownloadImageTask(item.getmImageUrl(), holder.icon);
        if (!holder.mTask.isCancelled()) {
            holder.mTask.execute();
        }

        return rowView;
    }

    @Override
    public int getCount() {

        return (this.mObjects.size());
    }

    @Override
    public Object getItem(int position) {

        return (this.mObjects.get(position));
    }

    @Override
    public long getItemId(int position) {

        return (position);
    }

    public AbsListView.RecyclerListener mRecyclerListener = new RecyclerListener( ){

        public void onMovedToScrapHeap(View view) {
            ViewHolder viewHolder = (ViewHolder) view.getTag();
            DownloadImageTask imagetask = viewHolder.mTask;
            if (imagetask != null) {
                imagetask.cancel(true);
            }
        }

    };
}