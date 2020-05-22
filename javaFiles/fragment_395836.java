protected Void doInBackground(PostParams... postParam) {

    HttpURLConnection connection = null;

    try{
        connection = (HttpURLConnection) postParam[0].getmUrl().openConnection();
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setConnectTimeout(10000);

        //we know it is if of type user
        User userData = (User)postParam[0].getmPostObject();
        String userJsondata = userData.toJsonString();

        //get writing stream
        OutputStreamWriter outWriter = new OutputStreamWriter(connection.getOutputStream());
        outWriter.write(userJsondata);
        outWriter.flush();

        //get response
        int httpResponseCode = connection.getResponseCode();
        String responseMessage = connection.getResponseMessage();
    }
    catch (SocketTimeoutException ex){
        //log
    }
    catch (Exception ex) {
        //log
    }
    finally {
        connection.disconnect();
    }
    return null;
}