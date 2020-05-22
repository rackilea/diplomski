// java
Column[] cols = Arrays
    .stream(df.columns())
    .filter(x -> ! x.equals("names"))
    .map(n -> struct(lit(n).alias("c"), col(n).alias("v")))
    .toArray(Column[]::new);
Dataset<Row> exploded_df = df.select(col("names"), explode(array(cols)));