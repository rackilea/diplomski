class ClauseTypeDeserializer implements JsonDeserializer<ClauseType> {

    @Override
    public ClauseType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        // get data, e.g.: data = jpson.toString().getBytes();
        // construct result:
        return new DataMonitoringClauseType(data)
    }
}