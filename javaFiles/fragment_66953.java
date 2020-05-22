import java.io.FileNotFoundException;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.Iterator;
    import org.json.simple.JSONArray;
    import org.json.simple.JSONObject;
    import org.json.simple.parser.JSONParser;
    import org.json.simple.parser.ParseException;
    public class Tets {

        /**
         * @param args
         */
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            JSONParser parser = new JSONParser();
           try{
          /*  URL url = new URL("http://192.168.1.13/test/ProductWb.php?productId=9");
            HttpURLConnection conn ;
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(60);
            conn.setRequestProperty("Accept", "application/json");*/
            String json="";

            Object obj = parser.parse(new FileReader("C:\\XXX\\XX\\src\\javapackage\\t.json"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject.toJSONString());  //modeles object
            JSONArray name = (JSONArray) jsonObject.get("modeles");
            System.out.println(name.toJSONString());//array inside modeles array


            for (Object o : name)
              {
                JSONObject person = (JSONObject) o;
                 JSONObject person1 = (JSONObject)person.get("modele");
                              System.out.println(person.get("modele"));//modele object
                              System.out.println(person1.get("id_lang"));//modele attribute
              } 



        }catch(Exception e){e.printStackTrace();}

        }
    }