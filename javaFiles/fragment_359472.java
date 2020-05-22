List<String> strings = Lists.transform(
        options,
        new Function<Option<String>, String>() {
            @Override
            public String apply(Option<String> option) {
                return option.getReferencedObject();
            }
        }
);