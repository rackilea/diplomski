//your method slightly modified to take callback into account 
    public void downloadUrl(String stringUrl, final MyCallbackInterface callback) {
        new DownloadWebpageTask() {

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                callback.onDownloadFinished(result);
            }
        }.execute(stringUrl);
    }

    //...