public static class DateSerializer extends StdScalarSerializer<Date> {

        public DateSerializer() {
            super(Date.class);
        }

        @Override
        public void serialize(Date value, JsonGenerator gen, SerializerProvider provider)
            throws IOException {
            String output = value.toString();
            gen.writeString(output);
        }
    }

    public static class DateDeserializer extends StdScalarDeserializer<Date> {

        public DateDeserializer() {
            super(Date.class);
        }

        @Override
        public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {
            try {
                return Date.parse(p.getValueAsString());
            } catch (Exception e) {
                return null;
            }
        }
    }