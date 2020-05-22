NameValuePair dataToSend = new NameValuePair("key", dataToPost);
 postData = getQuery(dataToSend);



private String getQuery(NameValuePair params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        result.append(URLEncoder.encode(params.getKey(), "UTF-8"));
        result.append("=");
        result.append(URLEncoder.encode(params.getValue(), "UTF-8"));
//        }

        return result.toString();
    }

try {
       mWebView.postUrl(URL, postData.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    OR



URL url;
            String response = "";
            try {
                url = new URL(URL);

                HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                conn.setReadTimeout(TIMEOUT);
                conn.setConnectTimeout(TIMEOUT);
                conn.setRequestMethod("POST");
                conn.setChunkedStreamingMode(0);
                conn.setDoInput(true);
                conn.setDoOutput(true);


                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(dataToSend);

                writer.flush();
                writer.close();
                os.close();
                int responseCode = conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {
                    String line;
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    while ((line = br.readLine()) != null) {
                        response += line;
                    }
                } else {
                    response = "";

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return response;