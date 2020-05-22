public class TestHTTPConnection {

    boolean error = false;

    public InputStream getContent(URL urlToRead) throws IOException {
        InputStream result = null;
        error = false;
        HttpURLConnection conn = (HttpURLConnection) urlToRead.openConnection();
        try {
            conn.setRequestMethod("GET");
            result = conn.getInputStream();
        } catch (UnknownHostException e) {
            error = true;
            result = null;
            System.out.println("Check Internet Connection!!!");
        } catch (Exception ex) {
            ex.printStackTrace();
            error = true;
            result = conn.getErrorStream();
        }
        return result;
    }

    public boolean isError() {
        return error;
    }

    public static void main(String[] args) {
        TestHTTPConnection test = new TestHTTPConnection();
        InputStream inputStream = null;
        try {
            inputStream = test.getContent(new URL("https://news.google.com/"));
            if (inputStream != null) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(
                        inputStream));
                StringBuilder data = new StringBuilder();
                String line;
                while ((line = rd.readLine()) != null) {
                    data.append(line);
                    data.append('\n');
                }
                System.out.println(data);
                rd.close();
            }
        } catch (MalformedURLException e) {
            System.out.println("Check URL!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}