private static Gson gson = new GsonBuilder().registerTypeAdapter(byte[].class, new ByteArrayAdapter()).create();

    private static class ByteArrayAdapter implements com.google.gson.JsonSerializer<byte[]>, JsonDeserializer<byte[]> {

            @Override
            public byte[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return Base64.decode(json.getAsJsonObject().get("$value").toString().getBytes(),Base64.DEFAULT);
            }

            @Override
            public JsonElement serialize(byte[] src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(Base64.encodeToString(src, Base64.NO_WRAP));
            }
        }