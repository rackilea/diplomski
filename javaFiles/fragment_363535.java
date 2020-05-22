final Schema valueType = SchemaBuilder.builder().stringType();

Schema mapSchema = SchemaBuilder.map().values(valueType);
System.out.println(mapSchema);
// {"type":"map","values":"string"}

Schema recordSchemaWithMap = SchemaBuilder.builder("my.namespace.avro").record("MapData")
        .fields()
        .name("attributes").type(Schema.createMap(valueType)).noDefault()
        .endRecord();

System.out.println(recordSchemaWithMap);
// {"type":"record","name":"MapData","namespace":"my.namespace.avro","fields":[{"name":"attributes","type":{"type":"map","values":"string"}}]}