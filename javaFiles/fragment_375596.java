Collections2.filter(foos, new Predicate<FooObject>() {
        @Override
        public boolean apply(FooObject input) {
            return fooObject.isFlagged();
        }
    })