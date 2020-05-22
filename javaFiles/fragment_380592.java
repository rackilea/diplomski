GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        @Override
        public Date deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
                throws JsonParseException {
            try {
                return df.parse(json.getAsString());
            } catch (ParseException e) {
                return null;
            }
        }
    });
    Gson gson = gsonBuilder.create();