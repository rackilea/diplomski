JSONObject issueObj = new JSONObject(jsonContent);
Iterator iterator = issueObj.keys();
   while(iterator.hasNext()){
    String key = (String)iterator.next();
    JSONObject issue = issueObj.getJSONObject(key);

    //  get id from  issue
        String _pubKey = issue.optString("id");
    }