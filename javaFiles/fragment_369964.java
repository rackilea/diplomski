ImmutableMultimap<String, String> yourNewMap = metadata.entries()
            .stream()
            .filter(entry -> entry.getKey().matches("(AAA|BBB|CCC|DDD).*"))
            .collect(Collector.of(ImmutableMultimap.Builder<String, String>::new, 
                    ImmutableMultimap.Builder<String, String>::put, 
                    (left, right) -> {
                        left.putAll(right.build());
                        return left;
                    }, 
                    ImmutableMultimap.Builder::build));