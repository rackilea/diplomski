public void onDestroy() {
   super.onDestroy();
   if(dialog != null) {
     dialog.dismiss();
   }
 }