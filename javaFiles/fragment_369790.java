AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
AlertDialog alertDialog = alertDialogBuilder.create();

if(!alertDialog.isShowing()){   
  //if its visibility is not showing then show here 
   alertDialog.show();       
 }else{
  //do something here... if already showing       
  }