@Override
        public void serialize(MetricRegistry registry,
                              JsonGenerator json,
                              SerializerProvider provider) throws IOException {
            json.writeStartObject();
            json.writeStringField("version", VERSION.toString());