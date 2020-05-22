private LayoutInflater mInflater;
Context mContext;
public TestListAdapter(Context context,int viewResourceId, List<TestObjects>  
objects) {
    super(context, viewResourceId, objects);

    this.mContext = context;
    this.mInflater = LayoutInflater.from(context);
    this.iHostViewID = viewResourceId;

     }
@Override
public View getView(int pos, View convertView, ViewGroup parent) {
    CollectHolder holder = null;
    if (convertView == null) {
        convertView = mInflater.inflate(iHostViewID, null);
        holder = new CollectHolder(convertView);
        convertView.setTag(holder);
    } else {
        holder = (CollectHolder) convertView.getTag();
    }
    holder.testTV.setText("Testing...");
    return convertView;
}

class CollectHolder {
    TextView testTV;

    public CollectHolder(View root) {
        this.testTV = (TextView) root
                .findViewById(R.id.widget_listitem_test_TV);
    }
}