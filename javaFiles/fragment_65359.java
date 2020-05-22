public class SparkGroupBySample {
    public static void main(String[] args) {
    //SparkSession
    SparkSession spark = SparkSession
            .builder()
            .appName("SparkGroupBySample")
            .master("local")
            .getOrCreate();     
    //Schema
    StructType schema = new StructType(new StructField[] { 
            new StructField("key1", DataTypes.StringType, true, Metadata.empty()),
            new StructField("key2", DataTypes.StringType, true, Metadata.empty()),
            new StructField("data1", DataTypes.IntegerType, true, Metadata.empty()),
            new StructField("data2", DataTypes.IntegerType, true, Metadata.empty())});
    //Read csv
    Dataset<Row> dataSet = spark.read().format("csv").schema(schema).option("header", "true").option("delimiter", ",").load("c:\\temp\\sample.csv");
    dataSet.show();     
    //groupBy and aggregate
    Dataset<Row> dataSet1 = dataSet.groupBy("key1","key2").sum("data1","data2").toDF("key1","key2","sum1","sum2");
    dataSet1.show();
    //stop
    spark.stop();
   }
}