package com.example.zvideo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    String url ="https://api.myjson.com/bins/tn67c";
    private RequestQueue mQueue;
    ArrayList<Movie> movieList= new ArrayList<Movie>();
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQueue = Volley.newRequestQueue(this);
        txt = findViewById(R.id.titolo);

        jsonParse();
//        prova();

    }


    public void jsonParse(){

        String url ="https://api.myjson.com/bins/tn67c";

        JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray= response.getJSONArray("movie");

                            for(int i=0; i<jsonArray.length(); i++){
                                JSONObject emplyee = jsonArray.getJSONObject(i);

                                String titolo = emplyee.getString("titolo");
                                String url = emplyee.getString("url");
                                String icona= emplyee.getString("icona");

                                Movie movie= new Movie();
                                movie.setTitolo(titolo);
                                movie.setVideoFilePath(url);
                                movieList.add(i, movie);
                            }

                            Toast.makeText(getActivity(), "item add successfully", Toast.LENGTH_LONG).show();
                            if(movieList.isEmpty()){
                            txt.setText("vuoto");
                            }else{
                            txt.setText("pieno");
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
        mQueue.start(request);

    }

    public void prova(){
        int i=0;

        for(i=0; i<2; i++){
            String test= "ciao " + i;
            Movie movie= new Movie();
            movie.setTitolo(test);
            movieList.add(movie);
        }

    }

}