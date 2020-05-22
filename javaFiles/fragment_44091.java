List<InnerObject> result = 
    outerObjects.stream()
                .map(outerObject -> innerObjects.stream()
                                                .filter(innerObject -> someBooleanMethod(innerObject, outerObject))
                                                .findFirst()
                                                .orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());