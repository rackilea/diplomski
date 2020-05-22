class Player extends Activity{
  public static final String ACTION_PLAY = "com....PLAY";
  public static final String ACTION_PAUSE = "com...PAUSE";

  public void onNewIntent(Intent intent){
    if(intent.getAction().equals(ACTION_PLAY)){
      //Play
    }
    else if(intent.getAction().equals(ACTION_PAUSE){
      //Pause
    }
  }
}