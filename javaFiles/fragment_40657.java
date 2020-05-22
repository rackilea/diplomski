public static String convertStreamToString(HttpResponse response) {
    String responseBody = null;
    HttpEntity entity = response.getEntity();
    if (entity != null) {
        try {
            responseBody = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return responseBody;
}