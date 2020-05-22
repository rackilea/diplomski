public void onStart() 
         {
           super.onStart();
           // Init DB Objects
           helper = new DBHelper(getActivity());
           initControls();

         }