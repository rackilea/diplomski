try {
        URL url = null;
        String response = null;
        String parameters = "param1=value1&param2=value2";
        url = new URL("http://www.somedomain.com/sendGetData.php");
        //create the connection
        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
        //set the request method to GET
        connection.setRequestMethod("GET");
        //get the output stream from the connection you created
        request = new OutputStreamWriter(connection.getOutputStream());
        //write your data to the ouputstream
        request.write(parameters);
        request.flush();
        request.close();
        String line = "";
        //create your inputsream
        InputStreamReader isr = new InputStreamReader(
                connection.getInputStream());
        //read in the data from input stream, this can be done a variety of ways
        BufferedReader reader = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        //get the string version of the response data
        response = sb.toString();
        //do what you want with the data now

        //always remember to close your input and output streams 
        isr.close();
        reader.close();
    } catch (IOException e) {
        Log.e("HTTP GET:", e.toString());
    }