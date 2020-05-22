class ClauseTypeDeserializer extends StdDeserializer<DataMonitoringClauseType> {

    @Override
    public DataMonitoringClauseType deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        // get data, e.g.: data = jp.getCodec().readTree(jp).toString().getBytes();
        // construct result:
        return new DataMonitoringClauseType(data)
    }
}