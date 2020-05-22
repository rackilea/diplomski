public void populateListView() {
    try {
        String[] strings = mPuzzleNames.toArray(new String[mPuzzleNames.size()]);

        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                mAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, android.R.id.text1, strings);
                mListView.setAdapter(mAdapter);
            }
        });
    }
    catch (Exception e) {
        e.printStackTrace();
    }
}