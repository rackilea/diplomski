public class LoginPacket implements Packet{
  public void callListener() {
    ListenerLogin.notify(this);
            //you can add additional Listeners

  } 
}