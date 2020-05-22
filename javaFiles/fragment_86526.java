JSONObject sendObject = new JSONObject();
    try {

        JSONArray dobDocuments = new JSONArray();
        dobDocuments.put("https://stackoverflow.com/questions/50128021/volley-post-method-jsonarray");
        dobDocuments.put("https://stackoverflow.com/questions/50128021/volley-post-method-jsonarray");

        JSONArray educationDocuments = new JSONArray();
        educationDocuments.put("https://stackoverflow.com/questions/50128021/volley-post-method-jsonarray");
        educationDocuments.put("https://stackoverflow.com/questions/50128021/volley-post-method-jsonarray");


        JSONArray addressDocuments = new JSONArray();
        addressDocuments.put("https://stackoverflow.com/questions/50128021/volley-post-method-jsonarray");
        addressDocuments.put("https://stackoverflow.com/questions/50128021/volley-post-method-jsonarray");


        sendObject.put("dobDocuments", dobDocuments);
        sendObject.put("educationDocuments", addressDocuments);
        sendObject.put("addressDocuments", addressDocuments);
        sendObject.put("mobileNo", "9876543210");


    } catch (JSONException e) {

    }

    Log.e("JSONObject",sendObject.toString());