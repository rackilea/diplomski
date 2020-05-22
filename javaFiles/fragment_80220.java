package com.tag.instagramdemo.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tag.instagramdemo.R;
import com.tag.instagramdemo.lazyload.ImageLoader;

public class RelationShipAdapter extends BaseAdapter  implements Filterable {
    private InstagramApp mApp;
    private ListView lvRelationShipAllUser;
    public ArrayList<HashMap<String, String>> usersInfo;
    private ArrayList<HashMap<String, String>> usersInfo1;
     // added one more field for original data
    private ArrayList<HashMap<String, String>> originalUsersInfo;
    private List<String> originalData = null;
    private ArrayList<HashMap<String, String>> filteredData= null;
    private LayoutInflater mInflater;
    private ItemFilter mFilter = new ItemFilter();
    private LayoutInflater inflater;
    private LayoutInflater inflater1;
    //lvRelationShipAllUser = (ListView) findViewById(R.id.lvRelationShip);
    private ImageLoader imageLoader;
    Context context;
    public RelationShipAdapter(Context context,
            ArrayList<HashMap<String, String>> 
    usersInfo,ArrayList<HashMap<String, String>> usersInfo1) {
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater1 = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Log.d("OkHttp","debug4");
        this.usersInfo = usersInfo;
        this.usersInfo1 = usersInfo1;
         originalUsersInfo = usersInfo1.clone();
        //getFilter();
        this.imageLoader = new ImageLoader(context);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.relationship_inflater, null);
        View view1 = inflater1.inflate(R.layout.relationship_inflater_nothing, null);
        Log.d("usersInfonlist", "ImHere");

        Holder holder = new Holder();
        //holder.tvFullName1 = (TextView) view1.findViewById(R.id.tvFullName);

        //connectOrDisconnectUser();
        holder.ivPhoto = (ImageView) view.findViewById(R.id.ivImage);
        holder.tvFullName = (TextView) view.findViewById(R.id.tvFullName);
        holder.tvFullName.setText(usersInfo.get(position).get(
                Relationship.TAG_USERNAME));
        Log.d("tvFullNameTestIng",usersInfo.get(position).get(
                Relationship.TAG_USERNAME));
        imageLoader.DisplayImage(
                usersInfo.get(position).get(Relationship.TAG_PROFILE_PICTURE),
                holder.ivPhoto);

        return view;
    }


    @Override
    public Filter getFilter() {
        Log.d("OkHttpNList1", String.valueOf(mFilter));

        return mFilter;

    }

    private class Holder {
        private ImageView ivPhoto;
        private TextView tvFullName;
        private TextView tvFullName1;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return usersInfo.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            Log.d("OkHttpNList", "here1");
            //MAKE AT THE BEGINING
            String filterString = constraint.toString().toLowerCase();

            FilterResults results = new FilterResults();

            ArrayList<HashMap<String, String>> list = originalUsersInfo;

            int count = list.size();
            ArrayList<HashMap<String, String>> nlist = new ArrayList(count);

            String filterableString;
            Log.d("OkHttpNList", String.valueOf(list));

            for (int i = 0; i < count; i++) {
                filterableString = list.get(i).get("username");
                Log.d("OkHttpNList", String.valueOf(filterableString));


                if (filterableString.toLowerCase().contains(filterString)) {
                    nlist.add(list.get(i));
                }
            }
            Log.d("OkHttpNList", String.valueOf(nlist));

            results.values = nlist;


            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            usersInfo = (ArrayList<HashMap<String, String>>) results.values;
            Log.d("OkHttpNList", String.valueOf(usersInfo));

            notifyDataSetChanged();
        }

    }
}