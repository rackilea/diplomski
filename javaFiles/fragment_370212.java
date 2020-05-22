JsonObject      request             = new JsonObject();
request.addProperty("requestid", UUID.randomUUID().toString());
request.addProperty("type", "hotel");

JsonArray       jpArray         = new JsonArray();
jpArray.add(new JsonPrimitive(1.0));
jpArray.add(new JsonPrimitive(2.0));
jpArray.add(new JsonPrimitive(3.0));

request.add("markups", jpArray);