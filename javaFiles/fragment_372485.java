boolean isUsedBefore = mPrefs.getBoolean(FIRST_TIME_USED_KEY,false);

 if(isUsedBefore==true){
   //do nothing
 }else{
  dialog.show();
  }