String jsonContent = "{\"abc\":{\"linkedTo\":\"COUNT\"},\"plmtq\":{\"linkedTo\":\"TITLE\",\"decode\":\"TRUE\"}}";

GsonBuilder gsonBuilder = new GsonBuilder();
gsonBuilder.registerTypeAdapterFactory(myCustomTypeAdapterFactory);
Gson gson = gsonBuilder.create();

Map mapDeserialized = gson.fromJson(jsonContent, Map.class);