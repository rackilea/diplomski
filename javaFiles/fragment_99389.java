public static JSONObject registerTask(Context ctx, String sUrl, List<String> names, List<String> phoneNums) throws JSONException, IOException {
    JSONObject request = new JSONObject();

    request.putOpt("names", names);
    request.putOpt("phoneNums", phoneNums);

    sUrl = sUrl + "yourapiname";
    return post(sUrl, request.toString());
}

private static String sanitizeJSONBody(String body) {
    if (body.contains("password")) {
        body = body.replaceAll("\"password\":\"[^\"]+\"",
                "\"password\":******");
    }
    if (body.contains("newPassword")) {
        body = body.replaceAll("\"newPassword\":\"[^\"]+\"",
                "\"newPassword\":******");
    }

    return body;
}