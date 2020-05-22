private class LoadMoreDataTask extends AsyncTask<Void, Void, List<PostRow>>{
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //postList.clear();
        //do not clear
    }
    @Override
    protected List<PostRow> doInBackground(Void... params) {
        List<PostRow> tempList = new ArrayList<PostRow>()
        ...
                    //postList.add(test1);
                    //replace this with
                    tempList.add(test1);
        ...
        return tempList;
    }

    @Override
    protected void onPostExecute(List<PostRow> tempList) {     
        super.onPostExecute(tempList);
        postList.clear();
        postList.addAll(tempList);
        adapter.notifyDataSetChanged();
        int position = listViewPosts.getFirstVisiblePosition();
        View v = listViewPosts.getChildAt(0);
        int top = (v == null) ? 0 : v.getTop();
        listViewPosts.setSelectionFromTop(position, top);
    }
}