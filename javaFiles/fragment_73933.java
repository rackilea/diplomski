val outlierPairDStream = avgAll1h.union(avgPerPlug1h).transform{rdd => 

  val finalAvg = if(rdd.count() > 0) {
    rdd.filter({case (k, v) => (k == "all")}).map({case (k, v) => v}).collect()(0)
  } else { 0.0 }

  val rddBool = rdd.map({case(k, v) => (k, v > finalAvg)})

  rddBool.filter({case(k, v) => (k != "all")})
}