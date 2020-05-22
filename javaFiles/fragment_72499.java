package com.example.jsonparser;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Parser {

    private ArrayList<Data> mDataSource = new ArrayList<Data>();

    public Parser(String json) {
        jsonParser(json);
    }

    private void jsonParser(String json) {

        try {

            JSONObject obj = new JSONObject(json);
            JSONObject var = obj.getJSONObject("data");


            JSONArray list = var.getJSONArray("product");

            int len  = list.length();
            for (int i = 0; i < len; i++) {
                try {
                    JSONObject data = list.getJSONObject(i);
                    String state = data.getString("state");
                    String image = data.getString("image");
                    String title = data.getString("title");
                    String summary = data.getString("summary");
                    String url = data.getString("url");
                    ArrayList<String> addList = new ArrayList<String>();
                    JSONArray addArray = data.getJSONArray("address");
                    int size = addArray.length();
                    /**
                     * parser sub json
                     */
                    for(int j = 0; j < size; j++) {
                        addList.add(addArray.getJSONObject(j).getString("address"));
                    }
                    mDataSource.add(new Data(state, image, title, summary, addList, url));

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }


        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ArrayList<Data> getSource() {
        return mDataSource;
    }
}