@Test(threadPoolSize = 10, enabled = false)
public void writeSinglePointPerformance() throws InterruptedException {
    String dbName = "write_" + System.currentTimeMillis();
    this.influxDB.createDatabase(dbName);
    this.influxDB.enableBatch(2000, 100, TimeUnit.MILLISECONDS);
    String rp = TestUtils.defaultRetentionPolicy(this.influxDB.version());
    Stopwatch watch = Stopwatch.createStarted();
    for (int j = 0; j < SINGLE_POINT_COUNT; j++) {
        Point point = Point.measurement("cpu")
                .addField("idle", (double) j)
                .addField("user", 2.0 * j)
                .addField("system", 3.0 * j).build();
        this.influxDB.write(dbName, rp, point);
    }
    this.influxDB.disableBatch();
    System.out.println("Single Point Write for " + SINGLE_POINT_COUNT + " writes of  Points took:" + watch);
    this.influxDB.deleteDatabase(dbName);
}