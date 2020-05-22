class ImagePathJsonSerializer extends JsonSerializer<Image> {

    @Override
    public void serialize(Image image, JsonGenerator jsonGenerator,
            SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(image.path);
    }
}