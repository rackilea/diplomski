public void serialize(Map<EquipmentType, Integer> value, JsonGenerator gen, SerializerProvider provider)
        throws IOException {
    gen.writeStartArray();
    value.entrySet().forEach(entry -> {
        try {
            gen.writeStartObject();
            gen.writeObjectField("equipmentType", entry.getKey());
            gen.writeNumberField("quantity", entry.getValue());
            gen.writeEndObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    });
    gen.writeEndArray();
}