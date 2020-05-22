add_row_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Row added = getRow(); // remember about that parameter value
        if (mListener != null) mListener.onRowAdded(added);
    }
});