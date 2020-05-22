JavaSparkContext sparkContext; // provided
JavaPairRDD<String, IonValue> rdd; // provided
IonSexp filterExpression; // provided

Broadcast<IonSexp> filterExprBroadcast = sparkContext.broadcast(filterExpression);
rdd = rdd.filter(record -> myCustomFilter(filterExprBroadcast.value(), record));
filterExprBroadcast.destroy(false); // Only do this after an action is executed