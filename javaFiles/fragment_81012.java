private void getAllData(){
  Cursor c = mDbHelper.fetchAllJobs();
  startManagingCursor(c);

  while(c.moveToNext()){

        String company;
        String position;
        String number;

        int companyColumn = c.getColumnIndex(JobsDbAdapter.KEY_COMPANY);
        int positionColumn = c.getColumnIndex(JobsDbAdapter.KEY_POSITION);
        int numberColumn = c.getColumnIndex(JobsDbAdapter.KEY_NUMBER);


        company = c.getString(companyColumn);
        position = c.getString(positionColumn);
        number = c.getString(numberColumn); 


        Log.d(TAG, "Company is = "+company);
        Log.d(TAG, "Position is = "+position);
        Log.d(TAG, "Number is = "+number);
    }
}