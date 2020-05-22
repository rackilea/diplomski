DoubleSummaryStatistics summaryStatistics = list // avoid initialising list as 'null'
        .stream()
        .limit(13)
        .mapToDouble(MyC::getVal)
        .summaryStatistics();
double max = summaryStatistics.getMax();
double min = summaryStatistics.getMin();