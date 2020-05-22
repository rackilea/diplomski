package com.shifar.shifz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MyChecker extends Activity {

    TextView tvAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checker);

        tvAnimal = (TextView) findViewById(R.id.tvAnimal);

        try {
            // Main Node
            JSONArray mainNode = new JSONArray(loadJSONFromAsset()); // UPDATED

            // There are 2 objects, so looping through each one
            for (int i = 0; i < mainNode.length(); i++) {

                // Collect JSONObject in ith position
                JSONObject eachObject = mainNode.getJSONObject(i);

                // Assuming there's a TextView and refd. as tvZooLocation...
                tvAnimal.setText(eachObject.getString("zooLocation"));

            }

            // Parsing Finished

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private String loadJSONFromAsset() {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream is = getAssets().open("animals.json");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(is));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            bufferedReader.close();

            Log.d("X","Response Ready:"+stringBuilder.toString());

            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}