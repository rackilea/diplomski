JavaRDD<Integer> sorted = baseRdd.sortBy(x -> x, true, 5).zipWithIndex().cache();

Integer offset = 2;
Integer window = 2;

List<Integer> nth =
  sorted
  .filter(x -> x._2() >= offset && x._2() < offset + window)
  .map(x -> x._1())
  .collect();