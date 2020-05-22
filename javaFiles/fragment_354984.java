val oldHashCode = udf((x: Long) => x.hashCode)

// https://github.com/apache/spark/blob/v2.0.1/core/src/main/scala/org/apache/spark/util/Utils.scala#L1596-L1599
val nonNegativeMode = udf((x: Int, mod: Int) => {
  val rawMod = x % mod
  rawMod + (if (rawMod < 0) mod else 0)
})

val df = spark.range(0, 10)

val oldPart = nonNegativeMode(oldHashCode($"id"), lit(3))
val newPart = nonNegativeMode(hash($"id"), lit(3))

df.select($"*", oldPart, newPart).show