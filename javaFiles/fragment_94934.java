private static Dataset<Row> cloneDataset(Dataset<Row> ds) {
    List<Column> filterColumns = new ArrayList<>();
    List<String> filterColumnsNames = new ArrayList<>();
    scala.collection.Iterator<StructField> it = ds.exprEnc().schema().toIterator();
    while (it.hasNext()) {
        String columnName = it.next().name();
        filterColumns.add(ds.col(columnName));
        filterColumnsNames.add(columnName);
    }
    ds = ds.select(JavaConversions.asScalaBuffer(filterColumns).seq()).toDF(scala.collection.JavaConverters.asScalaIteratorConverter(filterColumnsNames.iterator()).asScala().toSeq());
    return ds;
}