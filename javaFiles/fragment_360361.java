JSONObject vSomeDictionary = new JSONObject();
  vSomeDictionary.put("content-available", 1);
  vSomeDictionary.put("alert", "SomeMessage");
  vSomeDictionary.put("sound", "default");
  JSONObject vJPayload = new JSONObject();
  vJPayload.put("aps", vSomeDictionary);