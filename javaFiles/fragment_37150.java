static String urlEncode(String value) {
    try {
        return URLEncoder.encode(value, "UTF-8");
    } catch (UnsupportedEncodingException e) {
        return value;
    }
}

// ... in your code:

String url = "https://api.parse.com/1/users?where="

url += urlEncode(
    "{\"$relatedTo\":{\"object\":{\"__type\":\"Pointer\",\"className\":\"_Role\",\"objectId\":\"{MY_OBJECT_ID}\"},\"key\":\"users\"}}"
);