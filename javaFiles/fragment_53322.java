myStringObservable = myIntObservable
    (...)    
    .map(new Function<Integer, String>() {
        @Override
        public String apply(Integer query){
            return "String Observable result == " + query;
        }
    });