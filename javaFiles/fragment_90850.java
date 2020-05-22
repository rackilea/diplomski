val dataArray = dataString.split("\\n")
    .map(_.split("\\s+")).map(_.map(_.toDouble))
    .map(f => ("k" + f(0), Array(f(1), f(2))))
  val data = sc.parallelize(dataArray)

  val dataStats = data.aggregateByKey(Array(new StatCounter(), new StatCounter()))({(s, v)=> Array(s(0) merge v(0), s(1) merge v(1))}, {(s, t)=> Array(s(0) merge t(0), s(1) merge t(1))})

  val result = dataStats.map(f => (f._1, (f._2(0).variance, f._2(0).max, f._2(0).min), (f._2(1).variance, f._2(1).max, f._2(1).min)))
    .foreach(println(_))