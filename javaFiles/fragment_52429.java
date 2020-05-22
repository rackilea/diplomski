import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class FlightsJava {

public static void main(String[] args) throws IOException {

    String request        = "http://partners.api.skyscanner.net/apiservices/pricing/v1.0/";
    URL    url            = new URL( request );
    HttpURLConnection conn= (HttpURLConnection) url.openConnection();           
    conn.setDoOutput( true );
    conn.setInstanceFollowRedirects( false );
    conn.setRequestMethod( "POST" );
    conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
    conn.setRequestProperty("Accept", "application/json");
    conn.setRequestProperty( "charset", "utf-8");


    String urlParameters = "apiKey=YOUR_API_KEY&country=BR&currency=BRL&locale=pt-BR&originplace=SDU&destinationplace=GRU&outbounddate=2016-09-23&locationschema=Iata&adults=1";   
    byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
    int    postDataLength = postData.length;

    conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));

    conn.setUseCaches( false );
    try{
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.write(postData);
        wr.flush();
        wr.close();

        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);
        System.out.println("Header Fields : " + conn.getHeaderFields());
    } catch (Exception e){
        System.out.println(e);
    }
}
}