List<Object> multiFieldsList = 
    multiFieldMap.entrySet()
                 .stream()
                 .flatMap(e -> e.getValue()
                                .stream()
                                .map(o -> queryService.query(e.getKey(), queryService.property("id").eq(o))))
                 .collect(Collectors.toList());