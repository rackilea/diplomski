public class GetTwitterContent implements Runnable {

    private String tag;
    private String type;

    public GetTwitterContent(String type, String tag) {
        this.type = type;
        this.tag = tag;
    }

    public void run() {

        try {

            Hashtable twitterValuesHashtable = new Hashtable();
            String serviceUrl = "";

            if (type.equalsIgnoreCase(Constants.TWITTER_CONTENT_TYPE_HASHTAG)) {
                serviceUrl = Constants.TWITTER_CONTENT_HASHTAG_CONTENT;
            } else if (type.equalsIgnoreCase(Constants.TWITTER_CONTENT_TYPE_USER)) {
                serviceUrl = Constants.TWITTER_CONTENT_USER_CONTENT;
            }

            ByteArrayOutputStream baos = getContent(serviceUrl + this.tag);
            JSONObject jsonObject = new JSONObject(new String(baos.toByteArray(), 0, baos.size(), "utf-8"));
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            for (int counter = 0; counter < jsonArray.length(); ++counter) {
                JSONObject thisJsonObject = (JSONObject) jsonArray.get(counter);
                TwitterResponse twitterResponse = new TwitterResponse();
                twitterResponse.setCreatedAt(thisJsonObject.optString("created_at", "na"));
                twitterResponse.setTweetText(thisJsonObject.optString("text","na"));
                twitterResponse.setFromUser(thisJsonObject.optString("from_user", "na"));
                twitterValuesHashtable.put(new Integer(counter),twitterResponse);
            }
            ServerContent.future.addContent(Constants.TWITTER_KEY, twitterValuesHashtable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ByteArrayOutputStream getContent(String url) {

        ByteArrayOutputStream baos = null;
        // len = 0;
        try {

            javax.microedition.io.HttpConnection connection = (javax.microedition.io.HttpConnection) Connector
                    .open(url);
            connection.setRequestMethod(HttpConnection.GET);
            // connection.setRequestProperty("Connection", "close");
            java.io.InputStream inputStream = connection.openDataInputStream();

            // inputStream = getClass().getResourceAsStream(url);
            baos = new ByteArrayOutputStream();
            int c;
            while (true) {
                c = inputStream.read();
                if (c == -1)
                    break;
                // ++len;
                baos.write(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return baos;
    }

}