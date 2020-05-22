DoubleSummaryStatistics stats = specificationEntryRequest.getComponentList().stream()
    .map(ComponentDetail::getStartingMaterialId)
    .mapToDouble(this::calculateBCMMatrixCostForAnalyte)
    .filter(price -> price > 0)
    .summaryStatistics();
double totalBcmMatrixCost = stats.gtSum ();
long nonZeroPriceCount = stats.getCount ();
double average = stats.getAverage ();