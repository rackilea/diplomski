public class FCMHelper {

    static Logger log = Logger.getLogger(FCMHelper.class);
    // Method to send Notifications from server to client end.

    public final static String AUTH_KEY_FCM = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

    public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

    // userDeviceIdKey is the device id you will query from your database

    public static void pushFCMNotification(String userDeviceIdKey ,String NotificationString) throws Exception{

       String authKey = AUTH_KEY_FCM; // You FCM AUTH key
       String FMCurl = API_URL_FCM; 

       URL url = new URL(FMCurl);
       HttpURLConnection conn = (HttpURLConnection) url.openConnection();

       conn.setUseCaches(false);
       conn.setDoInput(true);
       conn.setDoOutput(true);

       conn.setRequestMethod("POST");
       conn.setRequestProperty("Authorization","key="+authKey);
       conn.setRequestProperty("Content-Type","application/json");

       JSONObject json = new JSONObject();
       json.put("to",userDeviceIdKey.trim());
       JSONObject info = new JSONObject();
      // info.put("title", "Alert!"); // Notification title
       info.put("body", NotificationString); // Notification body
       json.put("data", info);

       OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
       wr.write(json.toString());
       wr.flush();
       conn.getInputStream();
       System.out.println("Notification Send Success!");
       System.out.println( conn.getInputStream().toString());

       InputStream in = new BufferedInputStream(conn.getInputStream());
        BufferedReader streamReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        StringBuilder responseStrBuilder = new StringBuilder();

        String inputStr;
        while ((inputStr = streamReader.readLine()) != null)
            responseStrBuilder.append(inputStr);
        String s = responseStrBuilder.toString();
         System.out.println( s);
         log.info(s);

    }
}