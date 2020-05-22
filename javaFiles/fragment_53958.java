JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

 JavaRDD<String> lines = sparkContext
            .textFile(args[0]);

JavaPairRDD<Integer,String> pairedRdd = lines.mapToPair(lines -> new Tuple2((lines.split("\t+")[2]).length(), lines));

        JavaPairRDD<Integer, String> sortedRdd = pairedRdd.sortByKey(true);

        List<Tuple2<Integer, String>> output = sortedRdd.take(1);

        System.out.println(output.get(0)._1+" "+output.get(0)._2);