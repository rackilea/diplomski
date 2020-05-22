public class MyAdapter extends BaseAdapter {
    private ArrayList myData;
    private Context mContext;

    public MyAdapter(Context context, ArrayList data){
        this.myData = data;
        this.mContext = context;
    }

    //I tell you how big and how many rows are going to be in the listview.
    @Override
    public int getCount() {
        return myData.size();
    }

    //I will return the object at an exact posiition in the listview.
    @Override
    public Object getItem(int position) {
        return myData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /*
    I create and configure the views for you! You can see here that we are taking a view, inflating it to our single row
    that we created earlier and then we can reference the textview or whatever else we want!
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    View view = convertView;
    if(convertView == null){
        view = View.inflate(mContext, R.layout.single_row, null);
    }
    TextView txt = (TextView)view.findViewById(R.id.textView);
    txt.setText(myData.get(position).toString());
    return view;
    }
}