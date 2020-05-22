IntSummaryStatistics summaryStatistics = testList.stream()
        .map(Test::getAge)
        .mapToInt(Integer::parseInt)
        .summaryStatistics();

int max = summaryStatistics.getMax();
int min = summaryStatistics.getMin();