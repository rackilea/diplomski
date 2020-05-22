package yourPackage;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        JSONArray root = new JSONArray(new String(Files.readAllBytes(Paths.get("test.json"))));

        JSONObject obj = new JSONObject();
        obj.put("submitted","");
        obj.put("limit", 0);
        obj.put("ID", 123);
        obj.put("target", 3);

        root.put(obj);

        Files.write(Paths.get("test.json"), root.toString().getBytes());
    }
}