jsonParser = new JSONParser();
public JSONArray loginUser(String username, String password) {
    // Building Parameters
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("tag", login_tag));
    params.add(new BasicNameValuePair("username", username));
    params.add(new BasicNameValuePair("password", password));
    // change the following line, to the correct method. Which parser do you use?
    JSONArray json = jsonParser.getJSONArrayFromUrl(loginURL, params);
    return json;
}