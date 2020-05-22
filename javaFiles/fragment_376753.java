class ObjDeserializer extends JsonDeserializer<Obj> {
    final BackupDateFormat backupDateFormat;

    public ObjDeserializer() {
        backupDateFormat = new BackupDateFormat(
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"),
            new SimpleDateFormat("yyyy-MM-dd"));
    }

    @Override
    public Obj deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        // create a POJO and populate with the fields from the JSON Object
        Obj obj = new Obj();
        JsonNode root = p.readValueAsTree();
        obj.setA(root.get("A").asText(""));
        obj.setC(root.get("C").asInt(0));
        try {
            obj.setB(backupDateFormat.parse(root.get("B").asText()));
        } catch (ParseException e) {
            throw new IOException("Could not parse date as expected.");
        }
        return obj;
    }

}