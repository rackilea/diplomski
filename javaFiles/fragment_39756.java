public String generateJsonFromCSV(File csvFile, File schemaJson) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

    //Get CsvSchema as Map
    Map<String, CsvSchema.ColumnType> map = getSchemaMapFromJson(schemaJson);
    //Create CsvSchema from CsvSchemaMap
    CsvSchema.Builder schemaBuilder = new CsvSchema.Builder();
    map.forEach(schemaBuilder::addColumn);
    CsvSchema schema = schemaBuilder.build();
    //read CSV
    CsvMapper csvMapper = new CsvMapper();
    MappingIterator<Map<?, ?>> mappingIterator = csvMapper.readerFor(Map.class).with(schema).readValues(csvFile);
    //Get configured JsonSerializer from CsvSchemaMap
    JSONSerializer jsonSerializer = getJsonSerializer(map);
    List<Map<?, ?>> lines = mappingIterator.readAll();
    //remove first line
    lines.remove(0);
    //serialize
    return jsonSerializer.deepSerialize(lines);
}

/**
 *
 * @param schemaMap mapping field to ColumnType
 * @return a configured JSONSerializer
 */
private JSONSerializer getJsonSerializer(Map<String, CsvSchema.ColumnType> schemaMap){
    Map<CsvSchema.ColumnType, Transformer> transformerMap = new EnumMap<>(CsvSchema.ColumnType.class);
    transformerMap.put(CsvSchema.ColumnType.STRING, new StringTransformer());
    transformerMap.put(CsvSchema.ColumnType.NUMBER, new NumberTransformer());
    JSONSerializer jsonSerializer = new JSONSerializer();
    for (Map.Entry<String, CsvSchema.ColumnType> columnTypeEntry : schemaMap.entrySet()) {
        jsonSerializer.transform(transformerMap.get(columnTypeEntry.getValue()),columnTypeEntry.getKey());
    }
    return jsonSerializer;
}

/**
 /**
 *
 * @param file JSON CsvSchema
 * @return fieldname ColumnType mapping
 * @throws ClassNotFoundException
 */
private Map<String, CsvSchema.ColumnType> getSchemaMapFromJson(File file) throws ClassNotFoundException {
    Map<String, String> schema = new JSONDeserializer<Map<String,String>>().deserialize(getResourceFileAsString(file.getName()));
    Map<String, CsvSchema.ColumnType> result = new HashMap<>(schema.size());
    for (Map.Entry<String, String> columnSchema : schema.entrySet()) {
        result.put(columnSchema.getKey(), CsvSchema.ColumnType.valueOf(columnSchema.getValue().toUpperCase()));
    }
    return result;
}