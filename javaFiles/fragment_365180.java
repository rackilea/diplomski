return specificationEntryRequest.getComponentList().stream()
    .map(ComponentDetail::getStartingMaterialId)
    .mapToDouble(this::calculateBCMMatrixCostForAnalyte)
    .filter(price -> price > 0)
    .average()
    .orElse(0.0);