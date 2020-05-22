for (Object aJsonArray : arr) {
       JSONObject foundJsonObject = (JSONObject) aJsonArray;

       JSONArray postsArr = (JSONArray) foundJsonObject.get("posts");
        for (Object bJsonArray : postsArr) {
            JSONObject postJsonObject= (JSONObject) bJsonArray;
             if (postJsonObject.get("post_id").equals(post_id)) {
                 returnArr.add(foundJsonObject);
           }
        }
   }