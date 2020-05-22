List<Model> output = tempList.stream()
        .collect(Collectors.groupingBy(Model::getName,
                Collectors.reducing(Model::mergeSimilarNames)))
        .values().stream()
        .filter(Optional::isPresent)
        .map(Optional::get)
        .collect(Collectors.toList());