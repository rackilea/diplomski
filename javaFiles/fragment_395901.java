ConcurrentMap<KEYTYPE, Set<VALUETYPE>> hashMap = new MapMaker()
                 .makeComputingMap(
        new Function<KEYTYPE, VALUETYPE>() {
         public Graph apply(KEYTYPE key) {
           return new HashSet<VALUETYPE>();
         }
       });