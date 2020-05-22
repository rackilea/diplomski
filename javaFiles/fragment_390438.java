import com.pubnub.api.*;
import org.json.*;

Pubnub pubnub = new Pubnub("demo", "demo");

Callback callback = new Callback() {
  public void successCallback(String channel, Object response) {
      Log.d("PUBNUB",response.toString());
  }
  public void errorCallback(String channel, PubnubError error) {
      Log.d("PUBNUB",error.toString());
  }
};

try {
  pubnub.subscribe("demo", callback);
    } catch (PubnubException e) {
  Log.d("PUBNUB",e.toString());
}

pubnub.publish("demo", "Hello World !!" , callback);