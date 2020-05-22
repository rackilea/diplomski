public class App 
{
    public static void main( String[] args )
    {
        post("http://www.baidu.com","+8912345");
    }

    public static JSONObject post(String url, String phone){
        InputStream inputStream = null;
        String result = "";

        try {
            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost(url);

            String json = "";

            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("phone", phone);

            // 4. convert JSONObject to JSON to String
            json = jsonObject.toString();

            // 5. set json to StringEntity
            StringEntity se = new StringEntity(json);

            // 6. set httpPost Entity
            httpPost.setEntity(se);

            // 7. Set some headers to inform server about the type of the content
            httpPost.addHeader("Accept", "application/json");
            httpPost.addHeader("Content-Type", "application/json;");

            // 8. Execute
            HttpResponse httpResponse = httpclient.execute(httpPost);

            // 9. receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

        } catch (ClientProtocolException e) {
            System.out.println("ClientProtocolException : "+e.getLocalizedMessage());
        } catch (IOException e) {
            System.out.println("IOException:"+ e.getLocalizedMessage());
        } catch (Exception e) {
            System.out.println("Exception:"+ e.getLocalizedMessage());
        }

        return null;
    }
}