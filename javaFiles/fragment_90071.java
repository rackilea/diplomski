Map<String, List<String>> map = Stream
            .of(
                    one.stream()
                            // use custom ListToMapCollector
                            .collect(new ListToMapCollector("below 100"))
                            // we can't stream collected Map directly, only through EntrySet
                            .entrySet(), 
                    two.stream()
                            .collect(new ListToMapCollector("above 100"))
                            .entrySet()) 
            // extract Entry<String, List<String>> 
            .flatMap(entrySet -> entrySet.stream())
             // convert Entry<String, List<String>> to Map<String, List<String>
            .collect(Collectors.toMap(
                    entry -> entry.getKey(),
                    entry -> entry.getValue()));