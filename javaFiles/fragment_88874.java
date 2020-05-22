String schema = "{\"namespace\": \"org.myorganization.mynamespace\"," //Not used in Parquet, can put anything
    + "\"type\": \"record\"," //Must be set as record
    + "\"name\": \"myrecordname\"," //Not used in Parquet, can put anything
    + "\"fields\": ["
    + " {\"name\": \"myInteger\", \"type\": \"int\"}," //Required field
    + " {\"name\": \"myString\",  \"type\": [\"string\", \"null\"]},"
    + " {\"name\": \"myDecimal\", \"type\": [{\"type\": \"fixed\", \"size\":16, \"logicalType\": \"decimal\", \"name\": \"mydecimaltype1\", \"precision\": 32, \"scale\": 4}, \"null\"]},"
    + " {\"name\": \"myDate\", \"type\": [{\"type\": \"int\", \"logicalType\" : \"date\"}, \"null\"]}"
    + " ]}";
Parser parser = new Schema.Parser().setValidate(true);
Schema avroSchema = parser.parse(schema);