public class StockStatistics {

    private DoubleSummaryStatistics profitStat = new DoubleSummaryStatistics();
    private DoubleSummaryStatistics profitPercentageStat = new DoubleSummaryStatistics();

    public void accept(Stock stock) {
        profitStat.accept(stock.getProfit());
        profitPercentageStat.accept(stock.getProfitPercentage());
    }

    public StockStatistics combine(StockStatistics other) {
        profitStat.combine(other.profitStat);
        profitPercentageStat.combine(other.profitPercentageStat);
        return this;
    }

    public static Collector<Stock, ?, StockStatistics> collector() {
        return Collector.of(StockStatistics::new, StockStatistics::accept, StockStatistics::combine);
    }

    public DoubleSummaryStatistics getProfitStat() {
        return profitStat;
    }

    public DoubleSummaryStatistics getProfitPercentageStat() {
        return profitPercentageStat;
    }

}