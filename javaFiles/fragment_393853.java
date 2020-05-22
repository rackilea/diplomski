finalResponse.getChosenStartingMaterials()
    .stream()
    .map(Analyte::getMatrixUtilisationMap)  // Stream<Map<String,Float>>
    .flatMap(it -> it.entrySet().stream())   
    .collect(Collectors.toMap(Map.Entry::getKey,
                              Map.Entry::getValue,
                              (v1, v2) -> v1.compareTo(v2) >= 0 ? v1 : v2));