finalResponse.getChosenStartingMaterials()
    .stream()
    .map(Analyte::getMatrixUtilisationMap)  // Stream<Map<String,Float>>
    .flatMap(it -> it.entrySet().stream())   
    .collect(Collectors.toMap(Map.Entry::getKey,
                              Map.Entry::getValue,
                              Float::max));