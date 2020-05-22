ConcurrentMap<Key, Graph> graphs = new MapMaker()
    .concurrencyLevel(32)
    .softKeys()
    .weakValues()
    .expiration(30, TimeUnit.MINUTES)
    .makeComputingMap(
        new Function<Key, Graph>() {
          public Graph apply(Key key) {
            return createExpensiveGraph(key);
          }
        });