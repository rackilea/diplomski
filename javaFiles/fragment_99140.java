private RowClickListener mListener;

public MyRecyclerViewAdapter(Context context, List<SomeObject> objects, RowClickListener listener) {
    mContext = context;
    mSomeObjectList = objects;
    mListener = listener;
}