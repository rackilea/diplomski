@Override
public View newView(Context context, Cursor cursor, ViewGroup parent) {
    int rowType = getItemViewType(cursor.getPosition());
    if (rowType == 0){
        return mInflater.inflate(R.layout.messagelist_item_sent, parent, false);
    } else if (rowType == 1){    
        return mInflater.inflate(R.layout.messagelist_item_recv, parent, false);
    } else {
        return null;
    }
}