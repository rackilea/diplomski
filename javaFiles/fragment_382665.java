import java.util.EventListener;

public interface MessageReceivedListener
    extends EventListener
{

  public void onMessageReceived( String message );

}