@Override
public void onBackPressed() {
    SharedPreferences sharePrefs = getSharedPreferences("busyDownloading", Context.MODE_PRIVATE);
    String getSharedUser = sharePrefs.getString("isItBusy", "");
    if (getSharedUser.equals("yes")){
        // AsyncTask - onPostExecute was not called = moveTaskToBack
        moveTaskToBack(true);
    }else {
        //AsyncTask - onPostExecute was called and application can be destroyed
        finish();
    }
}