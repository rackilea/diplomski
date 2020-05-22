List<String> strings = Lists.transform(ds, new Function<Double, String>() {
        @Override
        public String apply(Double from) {
            return from.toString();
        }
    });