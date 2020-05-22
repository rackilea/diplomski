public class CustomRequestInterceptor implements Interceptor {

    private static String newToken;
    private String bodyString;

    private final String TAG = getClass().getSimpleName();


    @Override
    public Response intercept(Chain chain) throws IOException {


        String token = "";
        Request request = chain.request();
        RequestBody oldBody = request.body();

        Buffer buffer = new Buffer();
        oldBody.writeTo(buffer);

        String strOldBody = buffer.readUtf8();
        Log.i(TAG, "original req " + strOldBody);
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        JSONObject jsonObject = new JSONObject();
        String decodedStr = decoder(strOldBody.replace("data=", ""));
        try {

            if (decodedStr != null && decodedStr.equalsIgnoreCase("")) {
                token = getRandomNumber();
                jsonObject.put("auth_token", token);
            } else {
                jsonObject = new JSONObject(decodedStr);
                token = getRandomNumber();
                jsonObject.put("auth_token", token);
            }

        } catch (Exception e) {
            Log.e(AppConstants.TAG, "Exception", e);
        }

        Log.i(AppConstants.TAG, "Request JSONObject " + jsonObject.toString());
        String strNewBody = "data=" + URLEncoder.encode(Encryption.encryptString(jsonObject.toString()));


        Log.i(TAG, "strNewBody " + strNewBody);
        RequestBody body = RequestBody.create(mediaType, strNewBody);

        Log.i(TAG, "content type is " + body.contentType().toString());
        Log.i(TAG, "content length is " + String.valueOf(body.contentLength()));
        Log.i(TAG, "method is " + request.method());

        request = request.newBuilder().header("Content-Type", body.contentType().toString())
                .header("Content-Length", String.valueOf(body.contentLength()))
                .method(request.method(), body).build();


        Response response = chain.proceed(request);
        String responseString = new String(response.body().bytes());
        Log.i(TAG, "Response: " + responseString);
        String newResponseString = Encryption.decryptString(responseString);
        JSONObject res_JsonObject = new JSONObject();
        if (newResponseString.startsWith("{")) {
            try {
                res_JsonObject = new JSONObject(newResponseString);
                String response_token = res_JsonObject.getString("auth_token");
                if (response_token.equalsIgnoreCase("" + token)) {

                } else {
                    res_JsonObject.put("status", false);
                    res_JsonObject.put("message", "Authentication Failed");
                    Toast.makeText(new AppController().getApplicationContext(), "Authentication Failed", Toast.LENGTH_LONG).show();
                }

            } catch (Exception e) {
                Log.e(AppConstants.TAG, "Exception", e);
            }
        }

        MediaType contentType = MediaType.parse(response.body().contentType() + "; charset=utf-32");

        return response.newBuilder()
                .body(ResponseBody.create(contentType, newResponseString.getBytes()))
                .build();
    }

    public String decoder(String encodedStr) {
        try {
            return URLDecoder.decode(encodedStr);

        } catch (Exception e) {

            Log.e(AppConstants.TAG, "Exception", e);
            return encodedStr;
        }
    }

}