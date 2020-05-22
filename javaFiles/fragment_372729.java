import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Test {
  /**
   * <pre>
   *  {
   *    "to":["91890xx", "91890xx"],
   *    "type": "document",
   *    "document" : {"caption" : "doc"},
   *    "callback":"{{callback}}"
   *  }
   * </pre>
   *
   * @param args
   * @throws JSONException
   */
   public static void main(String[] args) throws JSONException {
    String number1 = "91890";
    String number2 = "91890";
    String[] numbers = new String[]{number1, number2};

    JSONArray toNode = new JSONArray();
    for (String number : numbers) {
      toNode.put(number);
    }

    JSONObject jsonObj = new JSONObject();
    jsonObj.put("to", toNode);
    jsonObj.put("type", "document");
    jsonObj.put("document", new JSONObject().put("caption", "doc"));
    jsonObj.put("callback", "{{callback}}");

    System.out.println(jsonObj.toString());
  }
}