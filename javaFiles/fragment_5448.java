intDataBaseHelper = new IntDataBaseHelper(this);
    lstJob = (ListView)findViewById(R.id.lstJob);
    LoadJobList();

    //  Create the database (only if it doesn't exists)
    //  does so by copying from the assets
    if (CopyDBFromAssets.createDataBase(this,IntDataBaseHelper.DB_NAME)) {


        // Get the data from the database
        ArrayList<String> jobs = myhelper.getJobList();
        for (String s : jobs) {
            Log.d("JobList", "Found Job " + s);
        }
    } else {
        throw new RuntimeException("No Usable Database exists or was copied from the assets.");
    }
}


   // loads job to screen
    private void LoadJobList() {

       ArrayList<String> Joblist = intDataBaseHelper.getJobList();
       if (mAdapter == null) {
           mAdapter = new ArrayAdapter<String>(this,R.layout.header,R.id.header);
           mAdapter = new ArrayAdapter<>(this,R.layout.row,R.id.BtnComplete);
           mAdapter = new ArrayAdapter<>(this, R.layout.row, R.id.Job_name,Joblist);

           lstJob.setAdapter(mAdapter);
       } else {
           mAdapter.clear();
           mAdapter.addAll(Joblist);
           mAdapter.notifyDataSetChanged();
       }
   }


   public void JobComplete(View view){
   View parent = (View)view.getParent();
   TextView taskTextView=(TextView)parent.findViewById(R.id.BtnComplete);
   Log.e("String",(String) taskTextView.getText());