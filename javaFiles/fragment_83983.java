private class MyAsyncTask extends AsyncTask<Integer, Integer, Integer[]> {
    private ProgressDialog myWait = null;

    // This is on the UI thread itself
    protected void onPreExecute() {
        myWait  = new ProgressDialog(MainActivity.this);
        myWait.setMessage("Loading data, please wait");
        myWait.setCancelable(false);
        myWait.show();
    }

    // Separate worker thread is used here 
    protected Integer[] doInBackground(Integer...params) {
        //do the database loading
        return <your result - goes to onPostExecute>;
    }

    // This is on the UI thread itself
    protected void onPostExecute(Integer[] resultCell) {
        if (myWait  != null) {
            myWait.dismiss();
        }
    }
}