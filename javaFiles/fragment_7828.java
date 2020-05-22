import org.json.simple.JSONObject;

class JsonDemo {

   public static void main(String[] args){

      JSONObject obj = new JSONObject();

      obj.put("login","admin");
      obj.put("pass","admin123");

      StringWriter out = new StringWriter();
      obj.writeJSONString(out);

      String jsonText = out.toString();
      System.out.print(jsonText);
   }
}