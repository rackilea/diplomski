private static void logPercentileInfo() {
    double total = 0;
    for (Map.Entry<Long, Long> entry : CassandraTimer.histogram.entrySet()) {
        long value = entry.getValue();
        total += value;
    }

    double sum = 0.95*total;
    double totalSum = 0;

    SortedSet<Long> keys = new TreeSet<Long>(CassandraTimer.histogram.keySet());
    for (long key : keys) {

        totalSum += CassandraTimer.histogram.get(key);

        if(totalSum >= sum) {
           System.out.println(key);
           break;
        }
    }
}