// Create the httpclient
HttpClient httpclient = new DefaultHttpClient();

    // Prepare a request object
    HttpGet httpget = new HttpGet(url); 

    // Execute the request
    HttpResponse response;

    // return string
    String returnString = null;

    try {

       // Open the webpage.
        response = httpclient.execute(httpget);

        if(response.getStatusLine().getStatusCode() == 200){
            // Connection was established. Get the content. 

            HttpEntity entity = response.getEntity();
            // If the response does not enclose an entity, there is no need
            // to worry about connection release

            if (entity != null) {
                // A Simple JSON Response Read
                InputStream instream = entity.getContent();

                // Load the requested page converted to a string into a JSONObject.
                JSONObject myAwway = new JSONObject(convertStreamToString(instream));

                // Get the query value'
                String query = myAwway.getString("query");

                **// Make array of the suggestions
                JSONArray suggestions = myAwway.getJSONArray("suggestions");

                // Build the return string.
                returnString = "Found: " + suggestions.length() + " locations for " + query;
                for (int i = 0; i < suggestions.length(); i++) {
                    returnString += "\n\t" + suggestions.getString(i);
                }

                // Cose the stream.
                instream.close();
            }
        }
        else {
            // code here for a response othet than 200.  A response 200 means the webpage was ok
            // Other codes include 404 - not found, 301 - redirect etc...
            // Display the response line.
            returnString = "Unable to load page - " + response.getStatusLine();
        }
    }
    catch (IOException  ex) {
        // thrown by line 80 - getContent();
        // Connection was not established
        returnString = "Connection failed; " + ex.getMessage();
    }
    catch (JSONException ex){
        // JSON errors
        returnString = "JSON failed; " + ex.getMessage();
    }
    return returnString;
}

private static String convertStreamToString(InputStream is) {
    /*
     * To convert the InputStream to String we use the BufferedReader.readLine()
     * method. We iterate until the BufferedReader return null which means
     * there's no more data to read. Each line will appended to a StringBuilder
     * and returned as String.
     */
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    StringBuilder sb = new StringBuilder();

    String line = null;
    try {
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return sb.toString();
}