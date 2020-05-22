@Override
protected void onPreExecute() {
    super.onPreExecute();
    postList.clear();
    yourAdapter.notifyDataSetChanged();
}