import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPRequest extends AsyncTask< String, String, String >
{

    protected String theHTTPString = null;

    @Override
    protected String doInBackground( String... uri )
    {
        URL url = null;
        try
        {
            url = new URL( uri[0] );
        }
        catch( MalformedURLException e )
        {
            e.printStackTrace();
        }

        String responseString = null;
        try
        {
            HttpURLConnection httpclient = (HttpURLConnection) url.openConnection();

            int lResponseCode = httpclient.getResponseCode();
            if( lResponseCode != HttpURLConnection.HTTP_OK )
            {
                httpclient.disconnect();
                throw new IOException( "RESPONSE REJECTED WITH ERROR CODE: " + lResponseCode );
            }
            BufferedReader in = new BufferedReader(new InputStreamReader( httpclient.getInputStream() ));
            StringBuffer lStringBuffer = new StringBuffer();
            String inputLine;
            while( (inputLine = in.readLine()) != null )
            {
                lStringBuffer.append( inputLine );
            }
            httpclient.disconnect();
            in.close();
            responseString = lStringBuffer.toString();
        }
        catch( IOException e )
        {
            e.printStackTrace();
            return responseString;
        }
        theHTTPString = responseString;
        return responseString;
    }
}