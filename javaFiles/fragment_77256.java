private long calcTotalLag(Map<MetricName, ? extends Metric> metrics) {
   long totalLag = 0;
   for (Map.Entry<MetricName, ? extends Metric> entry : metrics.entrySet()) {
     MetricName metricName = entry.getKey();
     Metric metric = entry.getValue();
     Map<String, String> tags = metricName.tags();
     if (metricName.name().equals("records-lag") && tags.containsKey("partition")) {
        totalLag += ((Number) metric.metricValue()).longValue();
     }
   }

   return totalLag;
}