// convert your RDD into a PairRDD format
JavaPairRDD<String, Shows[]> pairs = result.mapToPair(new PairFunction<Tuple2<String,Shows[]>, String, Shows[]>() {
    public Tuple2<String, Shows[]> call(Tuple2<String, Shows[]> t) throws Exception {
        return t;
    }
});

// now flatMap the values in order to split them with their respective keys
JavaPairRDD<String, Shows> output = pairs.flatMapValues(
    new Function<Shows[], Iterable<Shows>>() {
        public Iterable<Shows> call(Shows[] shows) throws Exception {
            return Arrays.asList(shows);
        }
});

// do something else with them
output.foreach(new VoidFunction<Tuple2<String, Shows>>() {
    public void call(Tuple2<String, Shows> t) throws Exception {
        System.out.println(t._1() + " " + t._2());
    }
});