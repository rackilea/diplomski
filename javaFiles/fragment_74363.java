public class CustomSimpleCursorAdapter extends SimpleCursorAdapter {

    public CustomSimpleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return super.newView(context, cursor, parent);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        super.bindView(view, context, cursor);

        //HERE you can set the correct color for each item

        TextView item = (TextView) view.findViewById(R.id.r_lv_name);
        boolean exists = //check is item is selected
        if (!exists) {
             item.setTextColor(Color.parseColor("#2EFE2E"));
        } else {
             item.setTextColor(Color.parseColor("#000000"));
        }
    }
}