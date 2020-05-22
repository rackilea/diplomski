val outlierPairDStream = avgAll1h.union(avgPerPlug1h).transform{rdd => 
  var avgOfAll = 0.0

  if(rdd.count() > 0) {
    avgOfAll = rdd.filter({case (k, v) => (k == "all")}).map({case (k, v) => v}).collect()(0)
  }

  val finalAvg = avgOfAll

  val rddBool = rdd.map({case(k, v) => (k, v > finalAvg)})

  rddBool.filter({case(k, v) => (k != "all")})
}