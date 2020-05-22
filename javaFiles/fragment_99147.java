Tuple2<Object, String> scalaTuple = TupleDemo.tuple();

Tuple2<Integer, String> tuple = new Tuple2<Integer, String>(
  (Integer) scalaTuple._1(),
  scalaTuple._2()
);