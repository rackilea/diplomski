class MyAwesomeAsyncTask extends AsyncTask<Void, Void, String> {

    @Override
    protected void onPreExecute() {
        myTextView.setText("progress started");
    }

    @Override
    protected String doInBackground(final Void... voids) {
        String s = amazingCallToBackend();
        return s;
    }

    @Override
    protected void onPostExecute(final String s) {
        myTextView.setText(s);
    }
}