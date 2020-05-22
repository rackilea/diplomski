private View tableChild() {
    TableRow tr = new TableRow(this);
    View v = LayoutInflater.from(mContext).inflate(R.layout.layout_for_my_table_row, tr, false);
    //want to get childs of row for example TextView, get it like this:
    TextView tv = (TextView)v.findViewById(R.id.my_row_text_view);
    tv.setText("This is another awesome way for dynamic custom layouts.");
    return v;//have to return View child, so return made 'v'
}