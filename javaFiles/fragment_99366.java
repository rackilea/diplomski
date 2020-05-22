private void retrievePosts(){
        AsyncTask<Void,Void,Void> task = new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    postList= mainActivity.postTable.execute().get();
                    Log.e("TAG",postList.get(0).text);
                    newAdapter.updateList(postList);
                } catch (final Exception e) {
                }
                return null;
            }
        };

        runAsyncTask(task);
    }