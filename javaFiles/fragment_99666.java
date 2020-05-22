public int ROW_NUMBER = 5;

public View getView(int position, View convertView, ViewGroup parent)
{
 AbsListView.LayoutParams param = new AbsListView.LayoutParams(
                        android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                        gridview.getHeight()/ROW_NUMBER);
 convertView.setLayoutParams(param);


}