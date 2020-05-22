@Override
public void onItemLongClick(View view, int position) {
    if (!isMultiSelect) {
        selectEmailArrayList = new ArrayList<Email>();
        isMultiSelect = true;

        if (mActionMode == null) {
            mActionMode = startActionMode(mActionModeCallback);
        }
    }
    multi_select(position);
}