import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Newtest {
    public static String sendPostRequest(String requestUrl, String payload) {
        StringBuffer jsonString = new StringBuffer();
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(payload);
            writer.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = br.readLine()) != null) {
                jsonString.append(line);
                System.out.println(line);
            }
            br.close();
            connection.disconnect();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return jsonString.toString();
    }

    public static void main(String[] args) {
        List<String> values = new ArrayList<>();
        values.add("TCGA-LAML");
        String requestUrl = "https://api.gdc.cancer.gov/cases";
        sendPostRequest(requestUrl, preparePayload(values));

    }

    private static String preparePayload(List<String> values) {
        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            sb.append("\"" + value + "\",");
        }
        String desiredValue = sb.toString().substring(0, sb.toString().length() - 1);
        return "{ \"filters\": {\"op\":\"in\", \"content\":{ \"field\":\"cases.project.project_id\", \"value\":[" + desiredValue + "] } } }";
    }

}