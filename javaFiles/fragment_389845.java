Context _context;
List<String> listDataHeader;
HashMap<String, List<String>> listDataChild1, listDataChild2;

public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listDataChild1,
                             HashMap<String, List<String>> listDataChild2) {
    _context = context;
    this.listDataHeader = listDataHeader;
    this.listDataChild1 = listDataChild1;
    this.listDataChild2 = listDataChild2;
}

@Override
public View getChildView(int groupPosition, int childPosition, boolean b, View convertView, ViewGroup viewGroup) {
    String childText = (String) getChild(groupPosition, childPosition);
    String childText2 = listDataChild2.get(getGroup(groupPosition)).get(childPosition);

    if (convertView == null) {
        LayoutInflater infalInflater = (LayoutInflater) this._context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = infalInflater.inflate(R.layout.list_item, null);
    }

    TextView txtListChild = (TextView) convertView.findViewById(R.id.lblListItem);
    txtListChild.setText(childText);
    TextView txtListChild2 = (TextView) convertView.findViewById(R.id.lblListItem2);
    txtListChild2.setText(childText2);
    return convertView;
}