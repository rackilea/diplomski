public void onStart() 
 {
   super.onStart();
   initControls();
   // Init DB Objects
   helper = new DBHelper(getActivity());
 }