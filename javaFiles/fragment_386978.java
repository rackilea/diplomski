@Override
    protected void onPreExecute() {
        super.onPreExecute();
        SharedPreferences sharePrefss = c.getSharedPreferences("busyDownloading", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharePrefss.edit();
        editor.putString("isItBusy", "yes");
        editor.apply();
    }