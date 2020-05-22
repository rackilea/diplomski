try{
    URL url = new URL("http://tes23123t.com");
    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
    connection.setRequestMethod("GET");
    connection.connect();
    int respCode = connection.getResponseCode();
    System.out.println(respCode);
}catch(UnknownHostException e){
    System.out.println("Unknown Host!!");
}