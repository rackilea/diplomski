package test;

import org.json.JSONObject;

public class Test {

    public static void main(String[] args) {
        // Does not work
        // JSONObject jsonObj  = {"a":"1","b":null};

        JSONObject jsonObj  = new JSONObject("{\"a\":\"1\",\"b\":null,\"d\":1}");

        printValueAndType(getOrNull(jsonObj, "a")); 
        // >>> 1 -> class java.lang.String

        printValueAndType(getOrNull(jsonObj, "b")); 
        // >>> null -> class org.json.JSONObject$Null

        printValueAndType(getOrNull(jsonObj, "d")); 
        // >>> 1 -> class java.lang.Integer

        printValueAndType(getOrNull(jsonObj, "c")); 
        // >>> null -> null
        // throws org.json.JSONException: JSONObject["c"] not found. without a check
    }

    public static Object getOrNull(JSONObject jsonObj, String key) {
        return jsonObj.optString(key, null);
    }

    public static void printValueAndType(Object obj){
        System.out.println(obj + " -> " + ((obj != null) ? obj.getClass() : null)); 
    }
}