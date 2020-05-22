Bundle bundle = new Bundle();
bundle.putString("fields", "email,installed,first_name,last_name");
Request request = new Request(session, "me", bundle, HttpMethod.GET);
Response response = request.executeAndWait();
GraphObject obj = response.getGraphObject();
JSONObject json = obj.getInnerJSONObject();