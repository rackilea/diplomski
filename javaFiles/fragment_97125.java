import org.apache.spark.sql.types.{StructType, StructField, LongType}

val schema = StructType(Seq(
  StructField("A", StructType(Seq(
    StructField("B", LongType, true), 
    StructField("D", LongType, true)
  )), true),
  StructField("C", LongType, true)))