SharedPreferences mypref = getPreferences(MODE_PRIVATE);
boolean playSounds = mypref.getBoolean("playSounds", false);

if(playSounds){
   mp.start();
}