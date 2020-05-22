public class MyCursorAdapter extends SimpleCursorAdapter {
    public MyCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c, from, to);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        super.bindView(view, context, cursor);         
        TextView price = (TextView)view.findViewById(R.id.priceInfo);
        if(cursor.getLong(cursor.getColumnIndex(MyDBAdapter.KEY_PRICE)) == 5)
        {   
            price.setText("High");
            view.setBackgroundColor(/* red color? */);
        }
        else {
            price.setText("");
            view.setBackgroundColor(0x00000000);
        }
    }
}