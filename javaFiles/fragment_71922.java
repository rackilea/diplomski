public void onCompleted(List<GraphUser> users, Response response) {
    JSONArray arr = new JSONArray();
    JSONObject tmp;
    try {
        for(int i = 0; i < users.size(); i++) {
             tmp = new JSONObject();
             tmp.put("Id",users.get(i).id); //some public getters inside GraphUser?
             tmp.put("Username",users.get(i).username);
             tmp.put("FirstName",users.get(i).first_name);
             tmp.put("LastName",users.get(i).last_name);
             arr.add(tmp);
        }

        webView.loadUrl("javascript:fetchFriends("+arr.toString()+")");         
    } catch(JSONException e){
        //error handling
    }
}