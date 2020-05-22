class MyAsyncTask extends AsyncTask<Params, Progress, Result> {
    private Object arg1;

    public MyAsyncTask(Object arg1) {
        this.arg1 = arg1;
    }

    @Override 
    public Result doInBackground(Params... params) { }

    @Override
    public void onPostExecute(Result result) { }
}