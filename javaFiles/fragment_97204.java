public void updateFriends(String code) {
    Token accessToken = getAccessToken(code);
    Response response = getFriends(accessToken);
    if (response.getCode() == 200) {
        processFriends(accessToken, response);
    }
}

private void processFriends(Token accessToken, Response response) {
    JSONObject json = (JSONObject) JSONSerializer.toJSON(response.getBody());
    JSONArray datos = json.getJSONArray("data");
    for (Object o : datos)  {
        JSONObject friend = (JSONObject) o;
        processFriend(friend);
    }
}

private void processFriend(Token accessToken, JSONObject friend) {
    Response response = getFriendGraph(accessToken, friend.getString("id"));
    if (response.getCode() == 200){
        PerfilContacto pcBean = new JsonParse().parseFacebookElement(response.getBody());
        pcDAO.insertarContacto(pcBean); 
    }
}

//~ Service interaction

private Response getFriends(Token accessToken) {
    return sendSignedGetRequest(PROTECTED_RESOURCE_URL, accessToken);
}

private Response getFriendGraph(Token accessToken, String id) {
    return sendSignedGetRequest("https://graph.facebook.com/" + id, accessToken);
}

private Token getAccessToken(String code) {
    return service.getAccessToken(EMPTY_TOKEN, new Verifier(code));
}

private Response sendSignedGetRequest(String url, Token accessToken) {
    OAuthRequest request = new OAuthRequest(Verb.GET, url);
    service.signRequest(accessToken, request);
    return request.send();
}