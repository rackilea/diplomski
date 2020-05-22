private Dataset<Row> convertToMlInputFormat(List< MachineLearningDTO> data) {
    List<Row> rowData = data.stream()
            .map(dto ->
                    RowFactory.create(dto.getLabel() ? 1.0d : 0.0d, Vectors.dense(dto.getFeatures())))
            .collect(Collectors.toList());
    StructType schema = new StructType(new StructField[]{
            new StructField("label", DataTypes.DoubleType, false, Metadata.empty()),
            new StructField("features", new VectorUDT(), false, Metadata.empty()),
    });

    return spark.createDataFrame(rowData, schema);
}