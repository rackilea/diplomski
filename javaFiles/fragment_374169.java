public void retrievePosts(){
    AsyncTask<Void,Void,Void> task = new AsyncTask<Void,Void,Void>(){
        @Override
        protected Void doInBackground(Void... params) {
            try {
                postList= mainActivity.postTable.execute().get();
                Log.e("TAG",postList.get(0).text);
            } catch (final Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute() {
            newAdapter.updateList(postList);
        }
    };

    runAsyncTask(task);
}