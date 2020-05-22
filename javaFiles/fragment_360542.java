package com.example.prege.randomklasgenerator;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;


private String data = "";
private ArrayList<String> klaslist = new ArrayList<>();

//Make a constructor here - let name of class is MyClass

Context context;

public Myclass(Context context)
{
    this.context = context;
}


@Override
protected Void doInBackground(Void... voids) {
    try {
        URL url = new URL("http://mgroesink-001-site12.itempurl.com/api/student?studentclass=" + MainActivity.etKlas.getSelectedItem().toString());
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String jsonstring = bufferedReader.readLine();
        if(jsonstring != null) {
            try {
                JSONArray klassen = new JSONArray(jsonstring);

                for(int i = 0; i < klassen.length(); i++) {
                    String klasnaam = klassen.getString(i);

                    klaslist.add(klasnaam);
                }

                jsonstring = "";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}

protected void onPostExecute(Void aVoid) {
    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, klaslist);
    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    MainActivity.etKlas.setAdapter(dataAdapter);
}
}