private static String getValanceResult(ID2LUserContext userContext,
        URI uri, String query, String sPost, String sMethod, int attempts) {

    String sError = "Error: An Unknown Error has occurred";
    if (sMethod == null) {
        sMethod = "GET";
    }

    URLConnection connection;
    try {
        URL f = new URL(uri.toString() + query);

        //connection = uri.toURL().openConnection();
        connection = f.openConnection();
    } catch (NullPointerException e) {
        return "Error: Must Authenticate";
    } catch (MalformedURLException e) {
        return "Error: " + e.getMessage();
    } catch (IOException e) {
        return "Error: " + e.getMessage();
    }


    StringBuilder sb = new StringBuilder();

    try {
        // cast the connection to a HttpURLConnection so we can examin the
        // status code
        HttpURLConnection httpConnection = (HttpURLConnection) connection;
        httpConnection.setRequestMethod(sMethod);
        httpConnection.setConnectTimeout(20000);
        httpConnection.setReadTimeout(20000);
        httpConnection.setUseCaches(false);
        httpConnection.setDefaultUseCaches(false);
        httpConnection.setDoOutput(true);


        if (!"".equals(sPost)) {
            //setup connection
            httpConnection.setDoInput(true);
            httpConnection.setRequestProperty("Content-Type", "application/json");


            //execute connection and send xml to server
            OutputStreamWriter writer = new OutputStreamWriter(httpConnection.getOutputStream());
            writer.write(sPost);
            writer.flush();
            writer.close();
        }

        BufferedReader in;
        // if the status code is success then the body is read from the
        // input stream
        if (httpConnection.getResponseCode() == 200) {
            in = new BufferedReader(new InputStreamReader(
                    httpConnection.getInputStream()));
            // otherwise the body is read from the output stream
        } else {
            in = new BufferedReader(new InputStreamReader(
                    httpConnection.getErrorStream()));
        }

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            sb.append(inputLine);
        }
        in.close();

        // Determine the result of the rest call and automatically adjusts
        // the user context in case the timestamp was invalid
        int result = userContext.interpretResult(
                httpConnection.getResponseCode(), sb.toString());
        if (result == ID2LUserContext.RESULT_OKAY) {
            return sb.toString();
            // if the timestamp is invalid and we haven't exceeded the retry
            // limit then the call is made again with the adjusted timestamp
        } else if (result == userContext.RESULT_INVALID_TIMESTAMP
                && attempts > 0) {
            return getValanceResult(userContext, uri, query, sPost, sMethod, attempts - 1);
        } else {
            sError = sb + " " + result;
        }
    } catch (IllegalStateException e) {
        return "Error: Exception while parsing";
    } catch (FileNotFoundException e) {
        // 404
        return "Error: URI Incorrect";
    } catch (IOException e) {
    }
    return sError;
}