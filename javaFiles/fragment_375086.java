@Override
public void setSelection(int position) {
    super.setSelection(position);

    View v = this.getAdapter().getView(position, null, this);
    v.setFocusable(true);
    v.requestFocus();
}