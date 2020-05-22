package com.test;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONTest {
public static void main(String[] args){
JSONArray jsonArray = new JSONArray();
JSONObject j1 = new JSONObject();
j1.put("id", "1");
j1.put("read", "false");
j1.put("time", "143250176");
jsonArray.put(j1);

JSONObject j2 = new JSONObject();
j2.put("id", "2");
j2.put("read", "false");
j2.put("time", "143250177");
jsonArray.put(j2);

JSONObject j3 = new JSONObject();
j3.put("id", "3");
j3.put("read", "false");
j3.put("time", "143250178");
jsonArray.put(j3);

JSONArray newArray = new JSONArray();
for(int count=0; count<jsonArray.length(); count++)
{
    JSONObject localInstance = jsonArray.getJSONObject(count);
    if(localInstance.optString("time") != "")
    {
        String time = localInstance.getString("time");
        String newTime = "new "+time;
        localInstance.put("time", newTime);
        newArray.put(localInstance);
    }
}
System.out.println(newArray);
}
}