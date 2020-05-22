@Subscribe(threadMode = ThreadMode.MAIN)  
public void onMyEvent(Object o) {
    /* Refresh your adapter */

    data = tinyDB.getListObject("LogData", LogsData.class);

    mListadapter = new ListAdapter(data);
    mListadapter.notifyDataSetChanged();
    mRecyclerView.setAdapter(mListadapter);
};