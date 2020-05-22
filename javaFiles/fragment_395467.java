private Context context;
private String grupa;
private String[] dzieci;
public CustomAdapter(Context context, String groupNames, String[] childNames)
{
    this.context = context;
    this.grupa = groupNames;
    this.dzieci = childNames;
}

//region gettersFolded
@Override
public int getGroupCount() {
    return 1;
}

@Override
public int getChildrenCount(int position) {
    return dzieci.length;
}

@Override
public Object getGroup(int groupPosition) {
    return grupa;
}

@Override
public Object getChild(int group, int position) {
    return dzieci[position];
}

@Override
public long getGroupId(int group) {
    return group;
}

@Override
public long getChildId(int group, int position) {
    return position;
}

@Override
public boolean hasStableIds() {
    return false;
}

@Override
public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
    TextView textView = new TextView(context);
    textView.setText(grupa);
    textView.setPadding(10,10,10,10);
    textView.setBackgroundResource(R.drawable.btm_line_shape);
    textView.setTextSize(14);
    return textView;
}

@Override
public View getChildView(int groupPosition, int childPosition, boolean isExpanded, View view, ViewGroup parent) {
    TextView textView = new TextView(context);
    textView.setText(dzieci[childPosition]);
    textView.setTextSize(12);
    textView.setPadding(10,10,10,10);
    return textView;
}

@Override
public boolean isChildSelectable(int i, int i1) {
    return true;
}