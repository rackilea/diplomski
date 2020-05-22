public void onMessageReceived(String from, Bundle data) {
     String notificationJSONString = data.getString("notification");
     //then you can parse the notificationJSONString into a JSON object
     JSONObject notificationJSON = new JSONObject(notificationJSONString ); 
     String body = notificationJSON.getString("body");
     Log.d(TAG, "Notification Message is : " + body);
  }