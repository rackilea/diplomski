private class DownloadImgs extends AsyncTask<String, String, Void> {

    @Override
    protected Void doInBackground(String ...params) {

        for (String url : params) {
            getdownloadedFiles(url);
        }

        return null;
    }

    public void getdownloadedFiles(String url) {
        /* Existing code */
    }

    /* Other methods unchanged */
}