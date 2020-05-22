import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test2 {
    Map<String, String> someDataStructure = new LinkedHashMap<String, String>();
    File fileDir = new File("c:\\temp\\test.txt");

    public static void main(String[] args) {
        Test2 test = new Test2();
        try {
            test.readFileIntoADataStructure();
            test.writeFileFromADataStructure();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void readFileIntoADataStructure() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileDir)));
        String line;
        while ((line = in.readLine()) != null) {
            if (line != null && !line.trim().isEmpty()) {
                String[] keyValue = line.split(" ");
                // Do you own index and null checks here this is just a sample
                someDataStructure.put(keyValue[0], keyValue[1]);
            }
        }
        in.close();
    }

    private void writeFileFromADataStructure() throws IOException {
        Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileDir)));
        for (String key : someDataStructure.keySet()) {
            // Apply whatever business logic you want to apply here
            myBusinessMethod(key);
            out.write(key + " " + someDataStructure.get(key) + "\n");
            out.append("\r\n");
            out.append("\r\n");
        }
        out.flush();
        out.close();
    }

    private String myBusinessMethod(String data) {
        if (data.equalsIgnoreCase("Copies")) {
            someDataStructure.put(data, "0");
        }
        return data;
    }
}