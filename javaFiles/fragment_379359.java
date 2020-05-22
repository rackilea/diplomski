public class CustomListAdapter extends BaseAdapter {
    private  ArrayList<TimeSlot> list;

    private LayoutInflater mInflater;
    Context con;

    public CustomListAdapter(Context context, ArrayList<TimeSlot> list) {
        this.list = list;
this.con = context;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return list.size();        
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) 
    {
        convertView = new TextView(con);
//set layout params or inflate xml layout
        convertView.setText(list.get(position).time);
        convertView.setEnabled(list.get(position).isAvailable);
        return convertView;
    }
}