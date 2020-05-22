JavaPairRDD <Tuple2<String,Long>, Long> sortedRdd = rddMovieReviewReducedByKey.mapToPair(new PairFunction < Tuple2 < String, MovieReview > , Tuple2<String,Long>, Long > () {

    @Override
    public Tuple2 < Tuple2<String,Long>, Long > call(Tuple2 < String, MovieReview > t) throws Exception {
        return new Tuple2 < Tuple2<String,Long>, Long > (new Tuple2<String,Long>(t._1,t._2.count), t._2.count);
    }
}).sortByKey(new TupleMapLongComparator(), true, 100);


JavaPairRDD <String,Long> sortedRddToPairs = sortedRdd.mapToPair(new PairFunction<Tuple2<Tuple2<String,Long>,Long>, String, Long>() {

    @Override
    public Tuple2<String, Long> call(
            Tuple2<Tuple2<String, Long>, Long> t) throws Exception {
        return new Tuple2 < String, Long > (t._1._1, t._1._2);
    }

});