try (ParquetWriter<GenericData.Record> writer = AvroParquetWriter
        .<GenericData.Record>builder(fileToWrite)
        .withSchema(schema)
        .withConf(new Configuration())
        .withCompressionCodec(CompressionCodecName.SNAPPY)
        .build()) {
    for (GenericData.Record record : recordsToWrite) {
        writer.write(record);
    }
}