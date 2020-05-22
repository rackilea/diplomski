public void onClickDataBaseAsyncTask(View view){
    try{
        DataBaseTaskListener listener = new DataBaseTaskListener() {
            @Override
            public void onCompletedSendData(String result) {
                //Do what you need with the data
            }
        };
        DataBaseTask c = new DataBaseTask(YourCallingActivity.this, yourCommand, yourToken, listener);
        c.execute();
    }
    catch (Exception ex){
        Log.e(TAG, ex.getMessage());
    }
}