import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

public class JsonPathExample {

    private static final String json = "JSON STRING";

    public static void main(String[] args) {
        JSONArray output = JsonPath.read(json, "$.verdict[?(@.reputationStatus==\"KNOWN\")].sha256");
        System.out.println(output.toJSONString());
        JSONArray output2 = JsonPath.read(json, "$.verdict.[?(@.[\"reputationStatus\"]==\"KNOWN\")].sha256");
        System.out.println(output2.toJSONString());
    }

}