private class BgTasks extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(String... params) {

        bgTasksFinished(doneTask, result); // outer class method
    }
}