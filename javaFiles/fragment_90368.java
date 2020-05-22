stream.foreachRDD(rdd -> {
            OffsetRange[] offsetRanges = ((HasOffsetRanges) rdd.rdd()).offsetRanges();

            rdd.mapToPair(new PairFunction<ConsumerRecord<String, String>, String, String>() {
                @Override
                public Tuple2<String, String> call(ConsumerRecord<String, String> record) {
                    return new Tuple2<>(record.key(), record.value());
                }
            }).foreachPartition(partition -> {

                OffsetRange o = offsetRanges[TaskContext.get().partitionId()];
                System.out.println(o.topic() + " " + o.partition() + " " + o.fromOffset() + " " + o.untilOffset());

                if (partition.hasNext()) {

                    PrintWriter out = new PrintWriter("filename.txt");;
                    out.println(text);

                    try {
                        while (partition.hasNext()) {

                            Tuple2<String, String> message = partition.next();
                            out.println(message);
                        }

                    } catch (Exception e) {
                        e.printStackTrace(
                }

            });
        });
        ssc.start();
        ssc.awaitTermination();