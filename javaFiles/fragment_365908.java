public static void main(String[] args) throws Exception {
    sendPost(".../encRead", "HelloWorld");
}

protected static void sendPost(String url, String encData) throws Exception {
    String concatUrl = url + "?enc=" + encData;
    URL obj = new URL(concatUrl);
    [...]
    //wr.write("enc=" + encData);