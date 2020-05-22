public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

     Spinner spinner = (Spinner) parent;
     if(spinner.getId() == R.id.spinnerBetrag)
     {
       Log.d("Spinner 1","selected");                 
     }
     else if(spinner.getId() == R.id.spinnerDetails)
     {
        Log.d("Spinner 2","selected");    
     }

}