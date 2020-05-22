rdd.repartition(5).mapPartitions(x -> {
     while(x.hasNext()){
         Integer i = x.next();
         System.out.println(i);
     }
     return x;
 }).count(); // Count is just to force the execution of mapPartition (mapPartition is lazy and doesn't get executed until an action is called)