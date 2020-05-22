JSONObject obj = new JSONObject();

obj.put("id", userID);
obj.put("type", methoden);
obj.put("msg", msget);

// etc.

final String json = obj.toString(); // <-- JSON string