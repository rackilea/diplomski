public class MessageAdapter extends CursorAdapter {
    public MessageAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return super.getView(position, convertView, parent);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View rv = LayoutInflater.from(context).inflate(
                R.layout.messagelist_item,
                parent,
                false
        );
        return rv;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView mUser = view.findViewById(R.id.user);
        TextView mTimestamp = view.findViewById(R.id.timestamp);
        TextView mMessage = view.findViewById(R.id.message);

        mUser.setText(cursor.getString(cursor.getColumnIndex(ChatData.COL_CHATDATA_USER)));
        mTimestamp.setText(cursor.getString(cursor.getColumnIndex(ChatData.COL_CHATDATA_TIMESTAMP)));
        mMessage.setText(cursor.getString(cursor.getColumnIndex(ChatData.COL_CHATDATA_MESSAGE)));
    }
}