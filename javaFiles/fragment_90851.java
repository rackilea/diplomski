val n = 2

  val dataStats = data.aggregateByKey(List.fill(n)(new StatCounter()))(
      {(s, v)=> (s zip v).map{case (si, vi) => si merge vi}},
      {(s, t)=> (s zip t).map{case (si, ti) => si merge ti}})

  val result = dataStats.map(f => (f._1, f._2.map(x => (x.variance, x.max, x.min))))
    .foreach(println(_))