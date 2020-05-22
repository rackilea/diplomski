protected Integer doInBackground(String... params)
{
    try
    {
        //TODO check if params.length >=2 & not empty
        AndroidHttpClient client = AndroidHttpClient.newInstance("androidClient", getContext());
        HttpPost post = new HttpPost(params[0]);
        post.setHeader("content-type", "application/xml");
        post.setEntity(new StringEntity(params[1]));
        return client.execute(post).getStatusLine().getStatusCode();
    }
    catch (Exception e)
    {
        Log.e(TAG, e.getLocalizedMessage());
        return 0;
    }
}