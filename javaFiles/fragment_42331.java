public static class ViewHolder extends RecyclerView.ViewHolder {
    public EditText mEditText;
    public CustomEditTextListener customEditTextListener;

    public ViewHolder(View v, CustomEditTextListener customEditTextListener) {
        super(v);

        this.mEditText = (EditText) v.findViewById(R.id.item_edit_text);
        this.customEditTextListener = customEditTextListener;
        this.mEditText.addTextChangedListener(customEditTextListener);
    }
}