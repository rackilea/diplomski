public static void main(String[] args) throws Exception { 
    try {
    String auth = returnAuth(); //getting token from a file.
    String url1= "https://canvas.instructure.com/api/v1/courses";
    URL url = new URL(url1);
    HttpsURLConnection connection =(HttpsURLConnection) url.openConnection();
    connection.setRequestMethod("GET");     

    connection.setRequestProperty("Authorization", "Bearer "+auth);
    System.out.println("\nSending 'GET' request to URL : " + url);
    System.out.println("Response code:" + connection.getResponseCode());
    System.out.println("Response message:" + connection.getResponseMessage());

        // Read the response:
        BufferedReader reader = new BufferedReader(new InputStreamReader(
        connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
    catch (MalformedURLException e1) {
        e1.printStackTrace();
    } catch (IOException e2) {
        e2.printStackTrace();           
    }
}