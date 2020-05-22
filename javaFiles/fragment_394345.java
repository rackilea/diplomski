private double getPortfolioVariance(double portfolioVariance, List<AssetDto> assets, int historyLength) {
    Iterator<int[]> iterator = CombinatoricsUtils.combinationsIterator(assets.size(), 2);
    while (iterator.hasNext()) {
        final int[] combination = iterator.next();
        AssetDto firstAsset = assets.get(combination[0]);
        AssetDto otherAsset = assets.get(combination[1]);

        double weight = firstAsset.getWeight() / 100;
        double weightOther = otherAsset.getWeight() / 100;

        if (firstAsset.getStockReturns() != null && otherAsset != null) {
            List<Double> returns = firstAsset.getStockReturns().stream().limit(historyLength).collect(Collectors.toList());
            List<Double> returnsOther = otherAsset.getStockReturns().stream().limit(historyLength).collect(Collectors.toList());
            Covariance covariance = new Covariance();
            double assetsCovariance = covariance.
                    covariance(returns.stream().mapToDouble(Double::doubleValue).toArray(),
                            returnsOther.stream().mapToDouble(Double::doubleValue).toArray());
            portfolioVariance += 2 * weight * weightOther * assetsCovariance;
        }
    }
    return portfolioVariance;
}