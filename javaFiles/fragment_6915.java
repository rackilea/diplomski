class ClassDeserializer implements JsonDeserializer<Class> {

    @Override
    public Class deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        String jobClassName = json.getAsString();

        try {
            return Class.forName(jobClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}