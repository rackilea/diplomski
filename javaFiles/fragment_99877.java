import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.types.{StructType, StructField, StringType, IntegerType}

val sqlContext = new SQLContext(sc)       
val customSchema = StructType(Array(
    StructField("year", IntegerType, true),
    StructField("make", StringType, true),
    StructField("model", StringType, true),
    StructField("comment", StringType, true),
    StructField("blank", StringType, true)))

val df = sqlContext.read
    .format("com.databricks.spark.csv")
    .option("header", "true") // Use first line of all files as header
    .schema(customSchema)
    .load("cars.csv")