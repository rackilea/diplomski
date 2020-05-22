import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class TranslateText extends AppCompatActivity {
TextView TText;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_translate_text);
    TText = findViewById(R.id.TranslatedView);
    String text = "Hello world!";
    new TransText(text).execute();
}


private String translate(String langFrom, String langTo, String text) throws IOException {

    String urlStr = "https://script.google.com/macros/s/AKfycbzjyCsF9eoo7MR38wVg0WFU9oxc9I2aU4Bt4YPEiqtRLJLx0XU/exec" +
            "?q=" + URLEncoder.encode(text, "UTF-8") +
            "&target=" + langTo +
            "&source=" + langFrom;
    URL url = new URL(urlStr);
    StringBuilder response = new StringBuilder();
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestProperty("User-Agent", "Mozilla/5.0");
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
    }
    in.close();
    return response.toString();
}

private class TransText extends AsyncTask<Void, Void, String> {
    String text;

    public TransText(String text) {
        this.text = text;
    }

    @Override
    protected String doInBackground(Void... voids) {
        String result = null;
        try {
            result = translate("en", "zh-CN", text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if(result != null){
            TText.setText(result);
        }
    }
}
}