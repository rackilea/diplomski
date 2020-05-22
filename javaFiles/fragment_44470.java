import android.os.Bundle;
import android.app.Activity;

import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OrderSummary extends Activity {

    String streetValue;
    String numberValue;
    String cityValue;
    String commentValue;

    private EditText editStreetText, editNumberText, editCityText, editCommentText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        editStreetText = (EditText) findViewById(R.id.summary_street);
        editNumberText = (EditText) findViewById(R.id.summary_house);
        editCityText = (EditText) findViewById(R.id.summary_city);
        editCommentText = (EditText) findViewById(R.id.summary_comment);

        button = (Button) findViewById(R.id.button_post_data);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                streetValue = editStreetText.getText().toString();
                numberValue = editNumberText.getText().toString();
                cityValue = editCityText.getText().toString();
                commentValue = editCommentText.getText().toString();
                new SummaryAsyncTask().execute((Void) null);
            }
        }); 
    }

    class SummaryAsyncTask extends AsyncTask<Void, Void, Boolean> {

        private void postData(String street, String number, String city,
                String comment) {

            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://xxxxxxx.com/postdata.php");

            try {
                ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(4);
                nameValuePairs.add(new BasicNameValuePair("Street", street));
                nameValuePairs.add(new BasicNameValuePair("House", number));
                nameValuePairs.add(new BasicNameValuePair("City", city));
                nameValuePairs.add(new BasicNameValuePair("Comment", comment));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
            }
            catch(Exception e)
            {
                Log.e("log_tag", "Error:  "+e.toString());
            }
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            postData(streetValue, numberValue, cityValue, commentValue);
            return null;
        }
    }
}