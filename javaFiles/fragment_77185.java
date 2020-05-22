List<Tuple2<String, Integer>> left = new ArrayList<Tuple2<String, Integer>>();
left.add(new Tuple2<String, Integer>("A", 0));
left.add(new Tuple2<String, Integer>("B", 0));
left.add(new Tuple2<String, Integer>("C", 0));
left.add(new Tuple2<String, Integer>("D", 0));
left.add(new Tuple2<String, Integer>("E", 0));

List<Tuple2<String, Integer>> right = new ArrayList<Tuple2<String, Integer>>();
right.add(new Tuple2<String, Integer>("B", 1));
right.add(new Tuple2<String, Integer>("C", 5));
right.add(new Tuple2<String, Integer>("D", 21));

JavaPairRDD<String, Integer> leftRdd = sc.parallelizePairs(left);
JavaPairRDD<String, Integer> rightRdd = sc.parallelizePairs(right);

JavaPairRDD<String, Tuple2<Integer, Optional<Integer>>> lojRdd = leftRdd.leftOuterJoin(rightRdd);

JavaPairRDD<String, Integer> result = lojRdd.mapValues(new Function<Tuple2<Integer, Optional<Integer>>, Integer>() {
  @Override
  public Integer call(Tuple2<Integer, Optional<Integer>> v1) throws Exception {
    return v1._2().or(v1._1());
  }
});

result.foreach(new VoidFunction<Tuple2<String, Integer>>() {
  @Override
  public void call(Tuple2<String, Integer> t) throws Exception {
    System.out.println(t._1() + " " + t._2());
  }
});