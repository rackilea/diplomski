public class Processing extends AsyncTask<Void, Void, Void>

  ProgressDialog mProgress;
  @Override
        protected void onPreExecute() {
        super.onPreExecute();
        mProgress = new ProgressDialog(YOUR_ACTIVITIY.this);
        mProgress.setTitle("Processing");
        mProgress.setMessage("Please wait ...");
        mProgress.show();

        @Override
        protected Void doInBackground(Void... voids) {
        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,
                ContactsContract.Contacts.DISPLAY_NAME + " ASC");

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                while (cursor.moveToNext()){

                    String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)).trim();

                }
                cursor.close();
            }
        });
    }
}
 @Override
    protected void onPostExecute(Void v) {
        super.onPostExecute(v);
        mProgress.dismiss();
   }
}