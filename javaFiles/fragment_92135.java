final JSONObject loginRequestJSONObject = new JSONObject();
final JSONObject userJSONObject = new JSONObject();
userJSONObject.put("login", "myuser");
userJSONObject.put("password", "mypass");

loginRequestJSONObject.put("user", userJSONObject);
loginRequestJSONObject.put("commit", "Sign In");

JSONObject objectToSend = loginRequestJSONObject;