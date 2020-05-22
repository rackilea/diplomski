public static void main(String[] args) throws IOException {
    Integer httpServicePort = 8080;
    ServerLauncher serverLauncher = 
        new ServerLauncher.Builder()
        .set("log-file", "")
        .set("http-service-port", httpServicePort.toString())   
        .set("start-dev-rest-api", "true")
        .set("http-service-bind-address", "localhost")
        .setPdxReadSerialized(true)
        .build();

    serverLauncher.start();
    System.out.println("REST server successfully started, press any key to stop it...");
    String restapi ="http://localhost:" + httpServicePort + "/gemfire-api/v1/";

    try {
        URL obj = new URL(restapi);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("accept","application/json");
        int responseCode = con.getResponseCode();
        System.out.println("Response Code: " + responseCode);

         if (responseCode == HttpURLConnection.HTTP_OK) { // success
               BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
               String inputLine;
               StringBuffer response = new StringBuffer();
               while ((inputLine = in.readLine()) != null) {
                   response.append(inputLine);
               }

               in.close();
               System.out.println("Response: " + response.toString());
         }
    } catch (Exception exception) {
        exception.printStackTrace();
    }

    System.in.read();
    serverLauncher.stop();
    System.exit(0);
}