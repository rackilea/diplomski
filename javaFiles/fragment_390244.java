ConcurrentMap<Key, Graph> graphs = new MapMaker()
   .concurrencyLevel(4)
   .softKeys()
   .weakValues()
   .maximumSize(10000)
   .expireAfterWrite(10, TimeUnit.MINUTES)
   .makeComputingMap(
       new Function<Key, Graph>() {
         public Graph apply(Key key) {
           // this is where your values are created on demand
           return createExpensiveGraph(key);
         }
       });