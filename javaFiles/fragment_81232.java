/** Creating Connection **/
            URL serverAddress = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) serverAddress.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Content-Type", contentType);
            connection.setRequestMethod("POST");

            /** POSTing **/
            OutputStream os = connection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(getQuery());
            writer.flush();
            writer.close();
            os.close();
            connection.connect();

            int status = connection.getResponseCode();//this cannot be invoked before data stream is ready when performing HTTP POST
            PrinterClass.show(status);  //status
            if (status != 200)
                throw (new RESTfulWebServiceException("Invalid HTTP response status "
                    + "code " + status + " from web service server."));

private String getQuery() throws UnsupportedEncodingException
    {
        JSONObject jobj = new JSONObject();
        jobj.put("customerNumber", new JSONString("003"));
        jobj.put("mappingCode", new JSONString("jac_003"));
        jobj.put("name", new JSONString("johnny"));
        jobj.put("status", new JSONString("ACTIVE"));
        PrinterClass.show(jobj.toString());
        return jobj.toString();
    }