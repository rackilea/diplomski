try {
    HttpURLConnection locConn = (HttpURLConnection) locurl.openConnection();
                    //URL url = locConn.getURL();
    locConn.setRequestProperty("Authorization", basicAuth);
    locConn.setRequestMethod("GET");
    locConn.setRequestProperty("Content-Type", "application/json");
    locConn.setRequestProperty("X-Myauthtoken", userCredentials);
    retc = locConn.getResponseCode();
    reader = new BufferedReader(new InputStreamReader(locConn.getInputStream()));

    String sessionK = null;
    readVal = reader.readLine();

    if (retc == 200) {


    }

}catch (...)
{
    //handle exception 
}finally {
    //disconnect here
    locConn.disconnect();
}