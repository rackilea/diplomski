package javaapplication1;

import java.util.StringTokenizer;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class Tokenization {

    public static void main(String args[]) {
        JSONObject parentData = new JSONObject();
        JSONObject childData = new JSONObject();
        parentData.put("command", "dance");
        parentData.put("uid", "123123123");
        childData.put("uid", "007");
        childData.put("username", "sup");
        childData.put("password", "bros");
        parentData.put("params", childData);
        System.out.println(parentData);
        String result = getValue(parentData, "params.uid");
        System.out.println("Result:" + result);
    }

    public static String getValue(JSONObject inputJson, String field) {
        String resultValue = null;
        try {
            StringTokenizer stJson = new StringTokenizer(field, ".");
            int count = stJson.countTokens();
            JSONObject objecStore = new JSONObject();
            objecStore = inputJson;
            while (stJson.hasMoreTokens()) {
                String st = stJson.nextToken();
                if (count > 1) {
                    JSONObject objNode = objecStore.getJSONObject(st);
                    count--;
                    objecStore = objNode;
                } else {
                    System.out.println(st);
                    resultValue = objecStore.getString(st);
                }
            }

        } catch (JSONException e) {
        }
        return resultValue;
    }
}