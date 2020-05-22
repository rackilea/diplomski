public class SendPushNotification {

public static void main(String[] arg){
    PushNotification pushNoti = new PushNotification();

    //collect the device_tokens into JSONArray.
    // device_tokens is the tokens of user where we needs to send the push Messages.

    String id = "APA9******WVWA";

    JSONArray deviceTokenArray = new JSONArray();
    // if you want to send more than one device then you have to 
   // add more ids into JSONArray by using put method.
    deviceTokenArray.put(id);
    try {
        pushNoti.sentPushIntoAndroid(deviceTokenArray, "I Love to my sister and sending a push message in Android Device");

    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}