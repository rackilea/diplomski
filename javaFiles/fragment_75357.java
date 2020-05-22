import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonWriter;

public class JSONFIlewrite {
    public static String Vinno_Read;
    public static List<String> linststring;

    public static void main(String[] args) {
        try {

            JsonParser parser = new JsonParser();
            Object obj = parser.parse(new FileReader("C:\\Amaresh\\Test\\sample_json.json"));



            JsonObject jsonObject = (JsonObject) obj;
            System.out.println(jsonObject);
            linststring = new ArrayList<String>();
            // loop array
            JsonArray msg = (JsonArray) jsonObject.get("vins");
            Iterator<JsonElement> iterator = msg.iterator();
            while (iterator.hasNext()) {
                Vinno_Read = iterator.next().toString();
                System.out.println("Vinno_Read---->" + Vinno_Read);
            }



            Vin newVin = new Vin();
            newVin.setVin("3689");
            Gson gson = new Gson();
            String json = gson.toJson(newVin);
            System.out.println("json---->" + json);



            FileWriter file = new FileWriter("C:\\Amaresh\\Test\\sample_json2.json", false);
            JsonWriter jw = new JsonWriter(file);
            iterator = msg.iterator();
            Vins vins = new Vins();
            while (iterator.hasNext()) {
                vins.addVin(gson.fromJson(iterator.next().toString(), Vin.class));
            }
            vins.addVin(newVin);
            gson.toJson(vins, Vins.class, jw);
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}