class PointsDeser extends JsonDeserializer<List<Point2D.Float>> {
    @Override
    public List<Point2D.Float> deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        float[] coords = ctxt.readValue(p, float[].class);
        if (coords.length % 2 != 0) {
            throw new JsonParseException("Expected an even number of values.");
        }
        List<Point2D.Float> points = new ArrayList<>(coords.length / 2);
        for (int i = 0; i < coords.length; i += 2) {
            points.add(new Point2D.Float(coords[i], coords[i + 1]));
        }
        return points;
    }
}