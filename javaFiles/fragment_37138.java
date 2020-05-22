public class ExpandableListAdapter extends BaseExpandableListAdapter {
private Context context;
//private List<String> listDataHeader, listDataHeaderPrice;
//private HashMap<String, List<String>> listHashMap;
private List<Package> packageList;
private float discount = 0; //Added

public ExpandableListAdapter(Context context, List<Package> packageList) {
    this.context = context;
    this.packageList = packageList;
}

@Override
public int getGroupCount() {
    return packageList.size();
}

@Override
public int getChildrenCount(int groupPosition) {
    return packageList.get(groupPosition).getContent().size();
}

@Override
public Object getGroup(int groupPosition) {
    return packageList.get(groupPosition);
}

@Override
public Object getChild(int groupPosition, int childPosition) {
    return packageList.get(groupPosition).getContent().get(childPosition);
}

@Override
public long getGroupId(int groupPosition) {
    return groupPosition;
}

@Override
public long getChildId(int groupPosition, int childPosition) {
    return childPosition;
}

@Override
public boolean hasStableIds() {
    return false;
}

@Override
public View getGroupView(final int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
    String headerTitle = (String) packageList.get(groupPosition).getTitle();
    /** HEADER TEXT HERE */

    float headerPrice = packageList.get(groupPosition).getPrice();

    if (view == null) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.vip_package_listgroup, null);
    }
    LinearLayout bgcolor = view.findViewById(R.id.lblListHeaderLayout);
    TextView lblListHeader = (TextView) view.findViewById(R.id.lblListHeader);
    TextView lblListHeaderPrice = (TextView) view.findViewById(R.id.lblListHeader_Price);
    Button lblListHeaderButton = view.findViewById(R.id.lblListHeaderButton);

    lblListHeaderButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, drinks_selection.class);
            intent.putExtra("discount", discount); //Added
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    });

    lblListHeader.setText(headerTitle);
    float endPrice = headerPrice + discount; //Added
    if(endPrice < 0) endPrice = 0; //Added
    lblListHeaderPrice.setText(String.format("%.02f", endPrice).replace(".", ",") + "USD"); //Changed
    return view;
}

@Override
public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
    List<String> childTest = packageList.get(groupPosition).getContent();
    String childText = childTest.get(childPosition);

    if (view == null) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.vip_package_listitem, null);
    }
    TextView txtListChild = (TextView) view.findViewById(R.id.lblListItem);
    txtListChild.setText(childText);
    return view;
}

@Override
public boolean isChildSelectable(int i, int i1) {
    return false;
}

//Added this public method
public void setDiscount(float discount){
    this.discount = discount;
    notifyDataSetChanged();
}
}