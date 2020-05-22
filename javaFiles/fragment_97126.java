val rddV1 = sc.parallelize(Seq("{ \"A\": {\"B\": 1 } }"))
val df1 = sqlContext.read.schema(schema).json(rddV1)

val rddV2 = sc.parallelize(Seq("{ \"A\": {\"B\": 1 }, \"C\": 2 }"))
val df2 = sqlContext.read.schema(schema).json(rddV2)

val rddV3 = sc.parallelize(Seq("{ \"A\": {\"B\": 1, \"D\": 3 }, \"C\": 2 }"))
val df3 = sqlContext.read.schema(schema).json(rddV3)