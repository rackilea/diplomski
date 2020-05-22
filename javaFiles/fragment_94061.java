package com.stackoverflow.answers;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONReader {

static String JSON_STRING = "{\"fromdate\":1361912208000, \"todate\":1361998608000, \"datavalues\":[ { \"arrayName\":\"1st Array\", \"datavalue\":{ \"rowvalues\":[ { \"coldata\":[ \"1\", \"5342\", \"75\" ] }, { \"coldata\":[ \"23\", \"4465\", \"75\" ] } ], \"colnames\":[ { \"id\":\"id1\", \"type\":\"String\", \"label\":\"id\" }, { \"id\":\"id2\", \"type\":\"Number\", \"label\":\"number\" }, { \"id\":\"id3\", \"type\":\"Number\", \"label\":\"number\" } ] } }, { \"arrayName\":\"2nd Array\", \"dataTable\":{ \"rowvalues\":[ { \"coldata\":[ \"1\", \"5342\", \"75\" ] }, { \"coldata\":[ \"23\", \"4465\", \"75\" ] } ], \"colnames\":[ { \"id\":\"id1\", \"type\":\"String\", \"label\":\"id\" }, { \"id\":\"id2\", \"type\":\"Number\", \"label\":\"number\" }, { \"id\":\"id3\", \"type\":\"Number\", \"label\":\"number\" } ] } } ] }";

public static void main(String[] args) {

    // Create root JSON Object
    JSONObject object = new JSONObject(JSON_STRING);
    System.out.println(object.get("fromdate"));
    System.out.println(object.get("todate"));
    System.out.println("--------------------------------");

    // Get Data Values
    JSONArray dataValues = object.getJSONArray("datavalues");

    System.out.println("------------- Data Values ---------------");

    JSONObject datavalue = dataValues.getJSONObject(0);
    System.out.println("Arrray Name : " + datavalue.getString("arrayName"));

    JSONObject dval = datavalue.getJSONObject("datavalue");

    System.out.println("------------- Row Values ---------------");
    JSONArray rowvalues = dval.getJSONArray("rowvalues");

    for (int y = 0; y < rowvalues.length(); y++) {
        JSONObject columns = rowvalues.getJSONObject(y);

        System.out.println("------------- Col data --------------");
        JSONArray coldata = columns.getJSONArray("coldata");

        for (int z = 0; z < coldata.length(); z++) {
            System.out.println(coldata.get(z));
        }
    }

    JSONArray colnames = dval.getJSONArray("colnames");

    for (int y = 0; y < colnames.length(); y++) {
        JSONObject columns = colnames.getJSONObject(y);

        System.out.println("------------- Col Names --------------");

        System.out.println(columns.get("id"));
        System.out.println(columns.get("type"));
        System.out.println(columns.get("label"));
    }

}