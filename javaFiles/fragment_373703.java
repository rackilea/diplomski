private class Asyn_GetNewsFromServer extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... params) {
        getNewsFromServer(beg);
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
                    //do what ever you want
    }
}