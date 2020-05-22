import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

    private static final String filePath = "E:\\project-test\\scloud\\test\\src\\main\\resources\\test";

    public static void main(String[] args) {

        try {
            // read the json file
            FileReader reader = new FileReader(filePath);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            System.out.println(jsonObject);


            JSONObject addedObj = (JSONObject) jsonObject.get("Added");
            System.out.println("Added is: " + addedObj);

            JSONObject newmemObject =(JSONObject) addedObj.get("newmem");
            System.out.println("newmemObject is: " + newmemObject);

            JSONObject idNewObj =(JSONObject) newmemObject.get("IDNew");
            System.out.println("IdNewObj is: " + idNewObj);

            long id =Long.valueOf((String) idNewObj.get("id"));
            System.out.println(id);


            idNewObj.put("id",809809809);

            System.out.println(jsonObject);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

    }

}