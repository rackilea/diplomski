public void sendPoints1(int w, int p){

    try {
        String url = "http://somename.com:309/api/Results";
        //value type is int ,don't need URLEncoder.
        byte[] data = ("key="+w+"&value="+p).getBytes("UTF-8");

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Length", data.length);
 connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); //URLencode...
        OuptputStream out = connection.getOutputStream();
        out.write(data);
        out.flush();
        InputStream in = connnection.getInputStream();
        //read .....
        System.out.println("Responce Code:    " + connection.getResponseCode());
        System.out.println("Responce Message: " + connection.getResponseMessage());
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }

}