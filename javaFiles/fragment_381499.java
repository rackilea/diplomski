class DefaultModelDeserializer extends JsonDeserializer<DefaultModel> {

    @Override
    public DefaultModel deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        DefaultModel responseModel = jp.readValueAs(DefaultModel.class);

        DefaultModel finalModel = new DefaultModel();
        finalModel.setName(responseModel.name);
        finalModel.setAge(responseModel.age == null || age.trim().isEmpty() ? "101" : responseModel.age);

        return finalModel;
    }

}