mAdapter = new ArrayAdapter....
    mList.setAdapter(mAdapter);

    // We have to post notifyDataSetChanged() here, so fast scroll is set correctly.
    // Without it, the fast scroll cannot get any child views as the adapter is not yet fully
    // attached to the view and getChildCount() returns 0. Therefore, fast scroll won't
    // be enabled.
    // notifyDataSetChanged() forces the listview to recheck the fast scroll preconditions.
    mList.post(new Runnable() {
        @Override
        public void run() {
            mAdapter.notifyDataSetChanged();
        }
    });