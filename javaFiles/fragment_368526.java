SparkSession spark = ...;

StructType schema = new StructType(new StructField[]{
    new StructField("col1", DataTypes.StringType, true, new MetadataBuilder().build()),
    new StructField("col2", DataTypes.StringType, true, new MetadataBuilder().build())
});

List<Row> rows = new ArrayList<>();
rows.add(RowFactory.create("A", "B"));
rows.add(RowFactory.create("C", "D"));
rows.add(RowFactory.create("A", "B"));
rows.add(RowFactory.create("A", "B"));

Dataset<Row> ds = spark.createDataFrame(rows, schema);
ds.createTempView("table");

// (1)
spark.sql("select col1, col2, count(*) as uniques from table group by col1, col2").show();

// (2)
ds.groupBy(ds.col("col1"), ds.col("col2")).count().show();

// (3)
ds.groupBy(ds.col("col1"), ds.col("col2"))
  .agg(functions.count(functions.lit(1)).alias("uniques") /*, functions.avg(...), functions.sum(...) */)
  .show();