public class menuListAdapter extends ArrayAdapter<List> {
private ArrayList<List> lists;
    private Activity activity;


public menuListAdapter(Activity a, int textViewResourceId, ArrayList<List> lists) {
    super(a, textViewResourceId, lists);
    this.lists = lists;
    activity = a;

}

public static class ViewHolder{
    public TextView name;
    public TextView message;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View v = convertView;
    ViewHolder holder;
    if (v == null) {        
        LayoutInflater vi = 
            (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = vi.inflate(R.layout.categorymenu, null);
        holder = new ViewHolder();
        holder.name = (TextView) v.findViewById(R.id.categoryname);
        holder.message = (TextView) v.findViewById(R.id.message);
        v.setTag(holder);
    }
    else
        holder=(ViewHolder)v.getTag();

    final List list = lists.get(position);
    if (list != null) {
        holder.name.setText(list.name);
        holder.message.setText(list.message);
    }

    return v;
}

}