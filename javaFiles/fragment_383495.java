@Override
    protected void onPreExecute() {
       isCurrentlyLoading = true;
    }

    @Override
    protected void onPostExecute(String result) {
       isCurrentlyLoading = false; 
    }