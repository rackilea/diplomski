class IndexPartitioner[V](n_per_part: Int, rdd: org.apache.spark.rdd.RDD[_ <: Product2[Long, V]], do_cache: Boolean = true) extends org.apache.spark.Partitioner {

    val max = {
        if (do_cache) rdd.cache()
        rdd.map(_._1).max
    }

    override def numPartitions: Int = math.ceil(max.toDouble/n_per_part).toInt
    override def getPartition(key: Any): Int = key match {
        case k:Long => (k/n_per_part).toInt
        case _ => (key.hashCode/n_per_part).toInt
    }
}