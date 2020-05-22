String json= "{\"command\":\"start\"}";

    //This will change change you BasicNameValuePair to an Entity with the correct Content Type
    StringEntity entity = new StringEntity(json,ContentType.APPLICATION_JSON);
    //Now you just set it to the body of your post
    post.setEntity(entity);