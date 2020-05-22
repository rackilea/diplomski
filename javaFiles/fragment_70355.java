lines.foreachRDD{ rdd => 
    val localDataCollection = rdd.collect
    localDataCollection.foreach{ keywordFreqPair => 
      val cql = "CREATE (n:Hashtag {name:'"+keywordFreqPair._1+"', freq:"+keywordFreqPair._2+"})"
      st.executeUpdate(cql)
}