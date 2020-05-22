//Net.java
static Data returnIp() throws UnsupportedEncodingException, MalformedURLException, IOException {
    //Ommited code, all it does is do a GET request to get response
    String responseString = new Scanner(response,"UTF-8").useDelimiter("\\A").next();

    return new Gson().fromJson(responseString, Data.class);  
}