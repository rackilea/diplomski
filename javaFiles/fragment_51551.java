JavaPairRDD<String, Integer> counts = lines.flatMap(line -> Arrays.asList(line.split(" ")).iterator())
            .mapToPair(word -> new Tuple2<String, Integer>(word, 1))
            .reduceByKey((x, y) ->  x +  y)
            .sortByKey();

counts.foreach(data -> {
        System.out.println(data._1()+"-"+data._2());
    });