private OnClickListener mEditClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
        int position = getListView().getPositionForView(v);
    }
}