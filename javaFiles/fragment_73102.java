IntSummaryStatistics stats = largeList.stream().
                                      .flatMap(List::stream)
                                      .mapToInt(Integer::intValue)
                                      .summaryStatistics();
System.out.println(stats.getMin());
System.out.println(stats.getMax());