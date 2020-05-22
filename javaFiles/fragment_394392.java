JavaPairRDD<Integer> vals = sc.parallelize(Arrays.asList(
      new Tuple2(0, 10),
      new Tuple2(1, 15), 
      new Tuple2(2, 0), 
      new Tuple2(3, 6), 
      new Tuple2(4, 2)));
    JavaRDD<Integer> valsGreaterThan5 = vals.filter(new Function<Tuple2<Integer, Integer>, Boolean>() {
        public Boolean call(Tuple2<Integer, Integer> x) {
            return (x._2 > 5);
        }
    }).map(new Function<Tuple2<Integer, Integer>, Integer>() {
        public Boolean call(Tuple2<Integer, Integer> x) {
           return x._1;
        }
    });