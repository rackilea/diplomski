JavaPairRDD<String, Shows> output = result.flatMapToPair(
    new PairFlatMapFunction<Tuple2<String, Shows[]>, String, Shows>() {
        public Iterable<Tuple2<String, Shows>> call(Tuple2<String, Shows[]> t) throws Exception {
            ArrayList<Tuple2<String, Shows>> ret = new ArrayList<>();
            for (Shows s : t._2())
                ret.add(new Tuple2<>(t._1(), s));
            return ret;
        }
    });