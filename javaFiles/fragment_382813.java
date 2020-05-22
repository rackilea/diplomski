@Override
void onStartCommand(Intent intent, int flag, int id){
    if(intent.getAction().equals("STOP")){
        stopSelf();
    }
    // code..
}