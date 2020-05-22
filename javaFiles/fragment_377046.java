JavaPairRDD<String,Integer> uniqueIP = counts.filter(newFunction<Tuple2<String,Integer>,Boolean()>{
   @Override
   public Boolean call(Tuple<String, Integer> v1) throws Exception {
   return v1._2.equals(1);
   }
});