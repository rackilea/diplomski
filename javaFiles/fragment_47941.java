String params = "{}";
    String myVar;
    try {
        params = IOUtils.toString(req.getContent().getInputStream(),
                "UTF-8");
    } catch (IOException e1) {
        // Handle exception properly
    }
    JSONObject postParams;
    try {
        postParams = new JSONObject(params);
        if (postParams.has("some-attribute")){
            myVar = postParams.getString("some-attribute");
        }
    } catch (JSONException e1) {
        // Handle exception properly
    }