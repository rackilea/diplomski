final JSONObject user = new JSONObject();
try {
  user.put("userId", "abc");
} catch (final JSONException e) {
  e.printStackTrace();
}
mSocket.emit("isActive", user);