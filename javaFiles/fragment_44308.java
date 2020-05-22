private class BackgroundTask extends AsyncTask<Void, Void, List<Post>> {

    @Override
    protected List<Post> doInBackground(Void... params) {
        // TODO
        return posts;
    }

    @Override
    protected void onPostExecute(List<Post> posts) {
        // TODO: update UI
    }
}