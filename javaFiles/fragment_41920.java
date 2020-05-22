public class HttpClient {

    public String getResponse(String connectionUrl) throws HttpException {

        HttpURLConnection connection = null;

        try {
            URL url = new URL(connectionUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                throw new HttpException("Response code was " + responseCode
                        + " (should be 200)");
            }

            Scanner scanner = new Scanner(connection.getInputStream())
                    .useDelimiter("\\A");
            String response = scanner.hasNext() ? scanner.next() : "";

            connection.disconnect();
            scanner.close();

            return response;

        } catch (IOException e) {

            if (connection != null) {
                connection.disconnect();
            }

            throw new HttpException(e.getMessage(), e.getCause());
        }
    }

}

class HttpException extends Exception {

    public HttpException(String string) {
        super(string);
    }

    public HttpException(String message, Throwable cause) {
        super(message, cause);
    }

}