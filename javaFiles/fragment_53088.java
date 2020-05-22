List<Person> list = new ArrayList<Person>();
JavaSparkContext ctx = new JavaSparkContext(new SparkConf());
JavaPairRdd<Object, BSONObject> rdd = ctx
  .parallelize(list)
  .mapToPair(person -> new Tuple2<Object, BSONObject>(person, convertToBson(person));

public BSONObject convertToBson(final Person person) {
  ...
}