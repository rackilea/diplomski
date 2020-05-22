public static void main(String[] args) throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
    server.createContext("/requests", new MyHandler());
    server.setExecutor(null); // creates a default executor
    server.start();

}

static class MyHandler implements HttpHandler {
    public void handle(HttpExchange t) throws IOException {

        //Receive the line from the POST
        InputStream in = t.getRequestBody();
        String readLine;
        BufferedReader br = new BufferedReader(new InputStreamReader(in)); 

        //connect to database here

        while (((readLine = br.readLine()) != null)) {          
            try {
                //Print request to console
                System.out.println(readLine);

                //convert Stream string to JSON object
                JSONObject reading = new JSONObject(readLine);

                //parse through the data here

                //insert data into the collection here


            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

        in.close();

        //acknowledge the post request
        String response = "Ack";
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();

    }
}