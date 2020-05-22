import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

public class SetRowsCustomAdapter extends ArrayAdapter<SetRows> {
    Context context;
   int layoutResourceId;
   ArrayList<SetRows> data=new ArrayList<SetRows>(); //data = countryList
   private ArrayList<SetRows> originalList;
   private NameFilter filter;

   public SetRowsCustomAdapter(Context context, int layoutResourceId, ArrayList<SetRows> data) {
       super(context, layoutResourceId, data);
       this.layoutResourceId = layoutResourceId;
       this.context = context;

       this.data = data;
       //this.data.addAll(data);

       this.originalList = new ArrayList<SetRows>();
       this.originalList.addAll(data);
   }

   @Override
   public View getView(int position, View convertView, ViewGroup parent) {
       View row = convertView;
       ImageHolder holder = null;

       if(row == null)
       {
           LayoutInflater inflater = ((Activity)context).getLayoutInflater();
           row = inflater.inflate(layoutResourceId, parent, false);

           holder = new ImageHolder();
           holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
           holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
           holder.txtID = (TextView)row.findViewById(R.id.txtModDate);
           row.setTag(holder);
       }
       else
       {
           holder = (ImageHolder)row.getTag();
       }

       SetRows myImage = data.get(position);
       holder.txtTitle.setText(myImage.name);
       holder.txtID.setText(myImage.id);
       int outImage=myImage.image;
       holder.imgIcon.setImageResource(outImage);
      return row;

   }

   static class ImageHolder
   {
       ImageView imgIcon;
       TextView txtTitle;
       TextView txtID;
   }
   @Override
   public Filter getFilter() {
    if (filter == null){
     filter  = new NameFilter();
    }
    return filter;
   }
   private class NameFilter extends Filter
   {

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {

     constraint = constraint.toString().toLowerCase();
     FilterResults result = new FilterResults();
     if(constraint != null && constraint.toString().length() > 0)
     {
     ArrayList<SetRows> filteredItems = new ArrayList<SetRows>();

     for(int i = 0, l = originalList.size(); i < l; i++)
     {
      SetRows nameList = originalList.get(i);
      if(nameList.toString().toLowerCase().contains(constraint))
       filteredItems.add(nameList);
     }
     result.count = filteredItems.size();
     result.values = filteredItems;
     }
     else
     {
      synchronized(this)
      {
       result.values = originalList;
       result.count = originalList.size();
      }
     }
     return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void publishResults(CharSequence constraint,
      FilterResults results) {

     data = (ArrayList<SetRows>)results.values;
     notifyDataSetChanged();
     clear();
     for(int i = 0, l = data.size(); i < l; i++)
      add(data.get(i));
     notifyDataSetInvalidated();
    }
   }
}