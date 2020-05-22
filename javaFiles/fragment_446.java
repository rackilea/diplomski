GsonBuilder gsonBuilder = new GsonBuilder();
gsonBuilder.registerTypeAdapter(Double.class,  new JsonSerializer<Double>() {

    public JsonElement serialize(Double src, Type typeOfSrc,
                JsonSerializationContext context) {
            Integer value = (int)Math.round(src);
            return new JsonPrimitive(value);
        }
    });

Gson gs = gsonBuilder.create();