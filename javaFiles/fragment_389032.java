import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.os.AsyncTask;

public class SendDataAsync extends AsyncTask<String, Void, String> {

    Context mContext;

    public SendDataAsync(Context context){
        this.mContext = context;
    }

    @Override
    protected String doInBackground(String... params) {

        String str = params[0];
            .
            .
            .

        HttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost("YOUR_URL");
        httpPost.addHeader("Content-type", "application/x-www-form-urlencoded");
        BasicNameValuePair strBasicNameValuePair = new BasicNameValuePair("str", str);
            .
            .
            .


        List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
        nameValuePairList.add(strBasicNameValuePair);
            .
            .
            .


        try {

            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairList);
            httpPost.setEntity(urlEncodedFormEntity);

            try {

                HttpResponse httpResponse = httpClient.execute(httpPost);
                InputStream  inputStream = httpResponse.getEntity().getContent();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder stringBuilder = new StringBuilder();
                String  bufferedStrChunk = null;
                while((bufferedStrChunk = bufferedReader.readLine()) != null){
                    stringBuilder.append(bufferedStrChunk);
                }

                return stringBuilder.toString();

            } catch (ClientProtocolException cpe) {
                System.out.println("Client Protocol Exception :" + cpe);
                cpe.printStackTrace();
            } catch (IOException ioe) {
                System.out.println("IO Exception :" + ioe);
                ioe.printStackTrace();
            }

        } catch (UnsupportedEncodingException uee) {
            System.out.println("An Exception given because of UrlEncodedFormEntity argument :" + uee);
            uee.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected void onPostExecute(String result) {

        super.onPostExecute(result);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        this.cancel(true);
    }


}