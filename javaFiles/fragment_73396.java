String json = "{\"AccountToken\":{\"string\":\"hello\"},\"Event\":{\"string\":\"t\"}}";
JSONObject genreJsonObject =(JSONObject)JSONValue.parseWithException(json);
JSONObject accountToken = (JSONObject) genreJsonObject.get("AccountToken");
System.out.println(accountToken.get("string"));

==> hello