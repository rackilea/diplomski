val vs = ns.withColumn("value", to_json(struct("id", "name")))
scala> vs.show(truncate = false)
+---+----+----------------------+
|id |name|value                 |
+---+----+----------------------+
|0  |zero|{"id":0,"name":"zero"}|
+---+----+----------------------+