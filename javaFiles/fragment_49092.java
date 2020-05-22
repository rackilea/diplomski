private static String getCookie(String userName, String password, String hostURL) {

    try {
        //Setting the url
        String url = hostURL + "/j_spring_security_check";
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        String USER_AGENT = "Mozilla/5.0";
        post.setHeader("User-Agent", USER_AGENT);
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        //Seting the body parameters for post call.
        urlParameters.add(new BasicNameValuePair("j_username", userName));
        urlParameters.add(new BasicNameValuePair("j_password", password));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);
        //Get the cookies in a string
        Header[] headers = response.getHeaders("Set-Cookie");
        String cookie = null;
        for (Header h : headers) {
            cookie = h.getValue().toString();
        }
        //return the cookie.
        return cookie;
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {

    }

    return null;
}