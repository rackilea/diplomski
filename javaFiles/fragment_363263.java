import org.apache.spark.sql.functions.{collect_set, flatten, array_distinct}

val byState = Seq(
  ("Canada", "America", Seq("A", "B")),
  ("Belgium", "Europe", Seq("Z")),
  ("USA", "America", Seq("A")),
  ("France", "Europe", Seq("Y", "X"))
).toDF("country", "continent", "attributes")

byState
  .groupBy("continent")
  .agg(array_distinct(flatten(collect_set($"attributes"))) as "attributes")
  .show