import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JsessionIdExtractor {

    public static void main(String[] args) throws Exception {
        String jSessionId = logInAndRetrieveJsessionId();
        System.out.println("JSESSIONID is: " + jSessionId);
    }

    private static String logInAndRetrieveJsessionId() throws Exception {
        String url = "http://127.0.0.1:8080/login";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Some browser name eg. fierfox");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        String postParameters = "user=user1&password=password1";
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(postParameters);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + postParameters);
        System.out.println("Response Code : " + responseCode);
        return extractJsessionId(con);
    }

    private static String extractJsessionId(HttpURLConnection con) {
        Map<String, List<String>> headerFields = con.getHeaderFields();
        Set<String> headerFieldsSet = headerFields.keySet();
        Iterator<String> hearerFieldsIter = headerFieldsSet.iterator();
        while (hearerFieldsIter.hasNext()) {
            String headerFieldKey = hearerFieldsIter.next();
            if ("Set-Cookie".equalsIgnoreCase(headerFieldKey)) {
                List<String> headerFieldValue = headerFields.get(headerFieldKey);
                for (String headerValue : headerFieldValue) {
                    System.out.println("Cookie Found...");
                    String[] fields = headerValue.split(";\\s*");
                    String cookieValue = fields[0];
                    if (cookieValue.toUpperCase().trim().startsWith("JSESSIONID")) {
                        return cookieValue.split("=")[1];
                    }
                }
            }
        }
        throw new RuntimeException("there is no JSESSIONID cookie in reponse");
    }
}