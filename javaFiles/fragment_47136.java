private static void setupPOSTConnection(HttpURLConnection connection) throws Exception  {
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            connection.setRequestProperty("Authorization", "Basic heregoestheencodedkeyandid");
StringBuilder postDataBuilder = new StringBuilder();
        byte[] postData = postDataBuilder.toString().getBytes("UTF-8");

        OutputStream out = conn.getOutputStream();
        out.write(postData);
        out.close();
            connection.connect();
        }