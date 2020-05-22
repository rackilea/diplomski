// after some cleanup of the string
String str = "{\"response\":{\"status\":{\"id\":45},\"data\":[{\"name\":\"Alice\",\"id\":123},{\"name\":\"Jack\",\"id\":345}]}}";

JsonParser parser = new JsonParser();
JsonObject element = (JsonObject)parser.parse(str);

JsonElement responseWrapper = element.get("response");

Gson gson = new Gson();
TheData data = gson.fromJson(responseWrapper, TheData.class);
System.out.println(data);