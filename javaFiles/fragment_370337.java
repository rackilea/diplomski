public StringBuilder post(String url, List<NameValuePair> nvps) {
    try {
        HttpPost httppost = new HttpPost(url);
        // if there is cookies, set then
        if (cookies != null && cookies.size() > 0) {
            String cookieString = "";
            for (int i = 0; i < cookies.size(); ++i) {
                cookieString += cookies.get(i).getName() + "=" + cookies.get(i).getValue() + "; ";
            }
            cookieString += "domain=" + Constants.BaseUrl + "; " + "path=/";
            httppost.addHeader("Cookie", cookieString);
        }
        // connection timeout options
        HttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters, Constants.timeoutConnection);
        HttpConnectionParams.setSoTimeout(httpParameters, Constants.timeoutSocket);
        // setup the post method
        DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
        httppost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
        HttpResponse response = httpClient.execute(httppost);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        StringBuilder builder = new StringBuilder();
        for (String line = null; (line = reader.readLine()) != null;)
            builder.append(line).append("\n");
        // set cookies
        List<Cookie> incomingCookies = httpClient.getCookieStore().getCookies();
        for (int i = 0; incomingCookies != null && i < incomingCookies.size(); i++) {
            cookies.add(incomingCookies.get(i));
        }
        return builder;
    } catch (UnsupportedEncodingException e) {
    } catch (ClientProtocolException e) {
    } catch (IOException e) {
    } catch (Exception e) {
    }
    return null;
}