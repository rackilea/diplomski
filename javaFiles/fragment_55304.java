JavaPairDStream<Long,Integer> sortedtsStream = tsStream.transformToPair(
            new Function<JavaPairRDD<Long, Integer>, JavaPairRDD<Long,Integer>>() {
                @Override
                public JavaPairRDD<Long, Integer> call(JavaPairRDD<Long, Integer> longIntegerJavaPairRDD) throws Exception {
                    return longIntegerJavaPairRDD.sortByKey(true);
                }
            });