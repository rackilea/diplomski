import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.toolbox.HttpClientStack;

public class PatchTask extends AsyncTask<String, Void, JSONObject>{
    JSONObject jobj;
    Activity activity;
    public PatchTask(Activity activity) {
        this.activity = activity;
    }

@Override
protected JSONObject doInBackground(String... params) {
    // TODO Auto-generated method stub

    HttpClient httpclient = new DefaultHttpClient();
    HttpClientStack clientStack = new HttpClientStack(httpclient);
    BufferedReader reader;
    String line=null;
    try {
        HttpResponse response =clientStack.performRequest(customReq, headers);
        Log.d("patch response>>", ""+response.toString());
        HttpEntity entity = response.getEntity();
        Log.d("patch entity", ""+entity.toString());
        if (entity != null) {


            InputStream instream = entity.getContent();
            Log.d("patch instream>>", ""+instream.toString());
            reader = new BufferedReader(new InputStreamReader(
                    instream, "UTF-8"), 8192);
            line = reader.readLine().toString();
            instream.close();
        }

    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    try {

        if (line != null) {
            jobj = new JSONObject(line);
        }

    } catch (JSONException e1) {
        e1.printStackTrace();
    }

    return jobj;
}

@Override
protected void onPostExecute(JSONObject result) {
    Log.d("patch post result:", ""+result);

    }


}