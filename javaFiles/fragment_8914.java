public class CustomAdapter extends ArrayAdapter<DataInfo> {


ArrayList<DataInfo> itemList =new ArrayList<>();
Context context;
LayoutInflater inflater;
public CustomAdapte(Context context, ArrayList<VegInfo> list) {
    super(context, R.layout.list_item, list);
    this.context = context;
    itemList = list;
    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}
@Override
public View getView(int position, View convertView, ViewGroup parent) {

    //getting an item from the list
    DataInfo item = itemList.get(position);
    if(convertView==null)
        convertView = inflater.inflate(R.layout.list_item,parent,false);

        //displaying some data from your data info in a textview
    TextView textView = (TextView) convertView.findViewById(R.id.tv);
    textView.setText(item.subitem);


    return convertView;
}
}