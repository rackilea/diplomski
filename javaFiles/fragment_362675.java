public class ProcessEntitySerializer extends StdSerializer<ProcessEntity> {


   ...

    @Override
    public void serialize(ProcessEntity entity, JsonGenerator jgen,
        SerializerProvider provider) throws IOException, JsonProcessingException {
        gen.writeStartObject();

        if (entity.getParentDomainEntity() == null) {
            // No parent, write null value for ID
            jgen.writeNullField("parentDomainEntityId");
        } else {
            // Parent is known, write it as an object
            jgen.writeObjectField(entity.getParentDomainEntity().getClass().getSimpleName(),
            entity.getParentDomainEntity());
        }

        // TODO: since you're using a custom serializer, you'll need to serialize any additional properties of the entity manually 
        // or use the Schema exposed by the base class StdSerializer

        jgen.writeEndObject();
    }
}