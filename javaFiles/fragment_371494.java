import org.json.JSONArray;
import org.json.JSONTokener;
import org.json.XML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertExample {
    public static void main(String[] args) throws IOException {
        JSONTokener tokener = new JSONTokener(Files.newInputStream(Paths.get("test.json")));
        JSONArray array = new JSONArray();

        while(tokener.nextClean() != '\u0000'){
            tokener.back();
            array.put(tokener.nextValue());
        }

        // Print XML with each array entry named node
        System.out.println(XML.toString(array, "node"));
    }
}