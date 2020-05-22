import java.net.*;
public class ShowStationV3Redirect {
public static void main(String[] args) throws Exception {
    URL url = new URL(args[0]);
    HttpURLConnection.setFollowRedirects(false);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    System.out.println("Response code = " + connection.getResponseCode());
    String header = connection.getHeaderField("location");
    if (header != null)
        System.out.println("www.stationv3.com redirected to " + header);
}
}