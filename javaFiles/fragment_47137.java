private static void setupPOSTConnection(HttpURLConnection connection) throws Exception  {
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");

                connection.setRequestProperty("Authorization", "Basic heregoestheencodedkeyandid");
    conn.setFixedLengthStreamingMode(0);
                connection.connect();
            }