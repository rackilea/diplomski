double max = getMaxDefault();
double min = getMinDefault();
if (!list.isEmpty()) {
    DoubleSummaryStatistics summaryStatistics = list
            .stream()
            .limit(13)
            .mapToDouble(MyC::getVal)
            .summaryStatistics();

    max = summaryStatistics.getMax();
    min = summaryStatistics.getMin();
}