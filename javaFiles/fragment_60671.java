private void updateMyActivity(Context context) {
     if(MainActivity.activityStatusFlag){
        //update the activity if activityStatusFlag=true;
        Intent intent = new Intent("mUpdateActivity");
        context.sendBroadcast(intent);        
     }else{
         //display notification if activityStatusFlag=false;
     }
}