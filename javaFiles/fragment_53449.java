public void onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    ..........Other codes.........

    --> mList = new ArrayList<MainContentListItem>();
    initData();
    mAdapter = new MainContentListAdapter(mList);

    ....................
}

public class FetchQTask extends AsyncTask<String, Void, ArrayList<MainContentListItem>> {

    ...... Some other codes ......

    @Override
    protected void onPostExecute(ArrayList<MainContentListItem> results) {
        // Here your mList array is not null because already instanciate onCreateView method.
        for(MainContentListItem result : results) {
            mList.add(result);
        }
        progressDialog.cancel();
    }
}