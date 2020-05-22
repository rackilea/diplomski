public class ParseJSON {
  public static void main(String[] args) throws Exception {
    String searchString = "two";
    JSONArray arr = new JSONArray(words);
    for(int k = 0; k < arr.length(); k++) {
        JSONObject obj = arr.getJSONObject(k);
        if(obj.getString("country").contains(searchString)) {
            System.out.println("Country: " + obj.getString("country"));
            System.out.println("City: " + obj.getString("city"));
            System.out.println("Start Time: " + obj.getString("Start Time"));
            System.out.println("End Time: " + obj.getString("End time"));
          }
      }
  }
}