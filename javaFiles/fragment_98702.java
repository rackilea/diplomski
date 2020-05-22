JavaRDD<DropResult> simCountRDD = spark.parallelize(makeRange(1,getSimCount())).map(new Function<Integer, DropResult>() 
{
  public DropResult call(Integer i) { 
     return pld.doDrop(); 
  }
});