public static String executePost(String targetURL, String requestJSON, String apikey) {
        HttpURLConnection connection = null;
        InputStream is = null;

        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            //TODO may be prod or preprod api key
            if (apikey.equals(Constants.APIKEY_PREPROD)) {
                connection.setRequestProperty("Authorization", Constants.APIKEY_PREPROD);
            }
            if (apikey.equals(Constants.APIKEY_PROD)){
                connection.setRequestProperty("Authorization", Constants.APIKEY_PROD);
            }
            connection.setRequestProperty("Content-Length", Integer.toString(requestJSON.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");  
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            System.out.println(requestJSON);
            DataOutputStream wr = new DataOutputStream (
            connection.getOutputStream());
            wr.writeBytes(requestJSON);
            wr.close();

            //Get Response  

            try {
                is = connection.getInputStream();
            } catch (IOException ioe) {
                if (connection instanceof HttpURLConnection) {
                    HttpURLConnection httpConn = (HttpURLConnection) connection;
                    int statusCode = httpConn.getResponseCode();
                    if (statusCode != 200) {
                        is = httpConn.getErrorStream();
                    }
                }
            }

            BufferedReader rd = new BufferedReader(new InputStreamReader(is));


            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }