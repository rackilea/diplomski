import java.io.*;
import java.util.*;

import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.entity.*;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.*;
import org.apache.http.impl.client.*;
import org.apache.http.message.*;

public class RESTHelper {

private static final String URL_POST = "http://url/login";
private static final String URL_GET = "http://url/login";

public static String connectPost(List<BasicNameValuePair> params){
    String result = "";
    try{
        HttpClient client = new DefaultHttpClient();

        HttpPost request = new HttpPost(URL_POST);

        request.setEntity(new UrlEncodedFormEntity(params));

        HttpResponse response = client.execute(request);

        HttpEntity entity = response.getEntity();
        if(entity != null){
            InputStream instream = entity.getContent();
            result = convertStreamToString(instream);
        }
    }catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return result;
}

public static String connectGet(List<BasicNameValuePair> params){
    String result = "";
    try{
        String finalUrl = URL_GET + URLEncodedUtils.format(params, null);

        HttpClient client = new DefaultHttpClient();

        HttpGet request = new HttpGet(finalUrl);

        HttpResponse response = client.execute(request);

        HttpEntity entity = response.getEntity();
        if(entity != null){
            InputStream instream = entity.getContent();
            result = convertStreamToString(instream);
        }
    }catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return result;
}

private static String convertStreamToString(InputStream is) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    StringBuilder sb = new StringBuilder(); 
    String line = null;
    try {
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return sb.toString();
}

}