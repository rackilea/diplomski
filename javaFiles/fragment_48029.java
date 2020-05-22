public static void index(String body) {

    Logger.info("content type: %s", request.contentType);
    Logger.info("json string: %s", body);
    MyObj obj = new Gson().fromJson(body, MyObj.class);
    ...
    ...
}