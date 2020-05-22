public class MyAdapter extends SimpleCursorAdapter
{
    //here goes methods that should be overriden

    //and method getView in which we can access layout of our list item
    @Override
    public View getView (int position, View convertView, ViewGroup parent)
    {
        View view = super.getView(postition, convertView, parent);
        TextView sts = (TextView) view.findViewById(R.id.stato);
        sts.setTextColor(android.graphics.Color.GREEN);
    }
}