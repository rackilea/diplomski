JSONObject soapDatainJsonObject = XML.toJSONObject(soapmessageString);
    JSONObject songs= soapDatainJsonObject.getJSONObject("app:service");
    JSONObject songs2 = songs.getJSONObject("app:workspace");
    JSONArray atomArray =  songs2.getJSONArray("app:collection");
    JSONObject atomTitle = atomArray.getJSONObject(0).getJSONObject("atom:title");
    String content = atomTitle.getString("content");
    System.out.println(content);