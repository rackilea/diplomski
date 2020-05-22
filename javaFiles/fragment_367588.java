@Override
public View getChildView(int groupPosition, final int childPosition,
                         boolean isLastChild, View convertView, ViewGroup parent) {

    final String childText = (String) getChild(groupPosition, 0);
    final String childTextSecond = (String) getChild(groupPosition, 1);
    final String childTextThird = (String) getChild(groupPosition, 2);
    final String deviceName = (String) getChild(groupPosition, 3);
    if (convertView == null) {
        LayoutInflater infalInflater = (LayoutInflater) this._context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = infalInflater.inflate(R.layout.list_item, null);
    }

    TextView txtListChild = (TextView) convertView
            .findViewById(R.id.lblListItem);

    TextView txtListChildTwo = (TextView) convertView
            .findViewById(R.id.lblListItemTwo);

    TextView txtListChildThree = (TextView) convertView
            .findViewById(R.id.lblListItemThree);

    //rest of logic!
}