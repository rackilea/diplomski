private OnEntryClickListener mOnEntryClickListener;

public interface OnEntryClickListener {
    void onEntryClick(View view, int position);
}

public void setOnEntryClickListener(OnEntryClickListener onEntryClickListener) {
    mOnEntryClickListener = onEntryClickListener;
}