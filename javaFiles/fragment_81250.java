package gorand.com.myapplication111;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button button1 = (Button) findViewById(R.id.btn_connect);

    button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            final CheckingSiteResponse task = new CheckingSiteResponse("http://111.68.99.8/StudentProfile/");
            task.execute();

        }
    });
}

public class CheckingSiteResponse extends AsyncTask<Void, Void, Boolean> {

    private final String mUrl;

    CheckingSiteResponse(String url) {
        mUrl = url;
    }

    @Override
    protected Boolean doInBackground(Void... params) {

        Boolean result = false;

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(mUrl).openConnection();
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(15000);
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            result = (200 >= responseCode && responseCode <= 399);

            Log.e("TAG", "RESPONCE = " + responseCode);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        Toast.makeText(MainActivity.this, "ONLINE = " + result, Toast.LENGTH_LONG).show();
    }
}