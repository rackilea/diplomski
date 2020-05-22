@Override
void onDestroy(){
    super.onDestroy();
    Intent intent = new Intent(this, YourService.class);
    intent.setAction("STOP");
    startService(intent);
}