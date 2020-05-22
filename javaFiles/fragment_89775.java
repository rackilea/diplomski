public class MyExpandableListAdapter extends BaseExpandableListAdapter {
public ArrayList<String> groupItem;
public ArrayList<Object> childItem;
public LayoutInflater minflater;

public MyExpandableListAdapter(ArrayList<String> grList,
            ArrayList<Object> childItem, Context context) {
        groupItem = grList;
        this.childItem = childItem;
        this.context = context;
        minflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

@Override
    public View getChildView(int groupPosition, final int childPosition,
            boolean isLastChild, View convertView, ViewGroup parent) {

        if (convertView == null) {
            if (groupItem.get(groupPosition).equals("desired_group_name")) {
                convertView = minflater.inflate(R.layout.desired_layout, null);
            } else {
                convertView = minflater.inflate(R.layout.other_layout, null);
            }
        }
}
}