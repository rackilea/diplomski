KafkaMetricsReporter[] kmrs = new KafkaMetricsReporter[]{
    new implementation1(),
    new implementation2()
};

for( KafkaMetricsReporter kmr: kmrs ){
    kmr.start();
}