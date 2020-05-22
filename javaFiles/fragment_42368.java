public class JavaHttpUrlConnectionReader {
    public static void main(String[] args) throws IOException{
        String results = doHttpUrlConnectionAction("https://your.url.com/", "GET");
        System.out.println(results);
    }
    public static String doHttpUrlConnectionAction(String desiredUrl, String requestType) throws IOException {
        BufferedReader reader = null;
        StringBuilder stringBuilder;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(desiredUrl).openConnection();
            connection.setRequestMethod(requestType);// Can be "GET","POST","DELETE",etc
            connection.setReadTimeout(3 * 1000);
            connection.connect();// Make call
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));// Reading Responce
            stringBuilder = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new IOException("Problam in connection : ", e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ioe) {
                    throw new IOException("Problam in closing reader : ", ioe);
                }
            }
        }
    }
}