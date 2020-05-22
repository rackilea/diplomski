private class BgTasks extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... params) {
        return doneTask;
    }
    @Override
    protected void onPostExecute(String doneTask) {
        bgTasksFinished(doneTask, result); // outer class method
    }
}