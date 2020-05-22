@Override
protected void onPostExecute(String result) {
    if (!TextUtils.isEmpty(result)) {
        txtStatus.setText("Ready");
    }
}