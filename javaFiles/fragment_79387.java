@Override
    protected void onPreExecute() {
        dialog = new ProgressDialog(YourActivity.this);
        dialog.setMessage("Progress start");
        dialog.show();
        Log.d(TAG, "Showing dialog");
    }

    @Override
    protected void onPostExecute(T result) {
        dialog.dismiss();
        Log.d(TAG, "Dismissing dialog");
    }