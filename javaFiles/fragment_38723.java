api.getObjectZZZ()
   .flatMap(new Function<Exchange2ObjectZZZ, SingleSource<AnotherObject>>() {
        @Override
        public SingleSource<AnotherObject> apply(Exchange2ObjectZZZ objectZZZ) throws Exception {
            AnotherObject anotherObject = objectZZZ.toAnotherObject();
            return Single.just(anotherObject);
        }
    })