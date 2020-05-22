@Override 
public int onStartCommand(Intent intent, int flags, int startId)
{ 
     Intent intent = new Intent(this, DisplayMessageActivity.class);
    startActivity(intent);

}