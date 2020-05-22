JavaPairRDD<String, Long> pairRdd = rdd.mapToPair((document) ->{
   String date = document.getString("date");
   String year = date.split(" ")[date.split(" ").length-1];// get the year
   return new Tuple2(year,1L);  //create pair of year and 1L the count for this row. 
}
JavaPairRDD<String, Long> counts = pairRdd.reduceByKey((a, b) -> a + b);// for all matching keys in the list accumulate the value