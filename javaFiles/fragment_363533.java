Serde<Tracking> trackinSerde = getAvroSerde(mockSchemaRegistryClient);
 Serde<Log> logSerde = getAvroSerde(mockSchemaRegistryClient);

private <T extends SpecificRecord> Serde<T> getAvroSerde(SchemaRegistryClient schemaRegistryClient) {

        OwnSpecificAvroSerde serde = new OwnSpecificAvroSerde(schemaRegistryClient,schemaRegistryUrl);
        return serde;
    }