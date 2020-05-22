private class GetRssFeed extends AsyncTask<String, Void, Void>
{
    ListView listView;
    String url;
    ArrayAdapter adapter;

    public GetRssFeed(String url, ListView listView, ArrayAdapter adapter) {
        this.listView = listView;
        this.url = url;
        this.adapter = adapter;
    }
    @Override
    protected Void doInBackground(String... params)
    {
        try
        {

            Log.d("tag", "nayana url "+url);
            RssReader rssReader = new RssReader(params[0]);
            Integer i = 0;
            for (RssItem item : rssReader.getItems())
            {
                adapter.add(item.getTitle());
                i++;
                if(i == 7)
                {
                    break;
                }
            }

        } catch (Exception e)
        {
            Log.v("Error Parsing Data", e + "");
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid)
    {
        super.onPostExecute(aVoid);
        adapter.notifyDataSetChanged();
        mList.setAdapter(adapter);
    }
}