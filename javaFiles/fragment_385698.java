public class Listeners {
AudioManager myAudMan;

Listeners(AudioManager audiomanager){
    this.myAudMan = audiomanager;
}

public void vibrate() {
    myAudMan.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
   }
}