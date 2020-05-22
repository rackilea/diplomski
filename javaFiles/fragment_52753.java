val df = sqlContext.read.json(sc.parallelize(Seq(
   """{"dog*woof":"bad dog 1","dog.woof":"bad dog 32"}"""
)))

df.groupBy("`dog.woof`").count.show
// +----------+-----+
// |  dog.woof|count|
// +----------+-----+
// |bad dog 32|    1|
// +----------+-----+