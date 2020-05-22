public void testRedis() {
    ScanParams scanParams = new ScanParams().count(1000);
    Set<String> allKeys = new HashSet<>();
    getRedisCluster().getClusterNodes().values().forEach((pool) -> {
        String cur = ScanParams.SCAN_POINTER_START;
        do {
            try (Jedis jedis = pool.getResource()) {
                ScanResult<String> scanResult = jedis.scan(cur, scanParams);
                allKeys.addAll(scanResult.getResult());
                cur = scanResult.getStringCursor();
            }
        } while (!cur.equals(ScanParams.SCAN_POINTER_START));
    });
    allKeys.stream().forEach(System.out::println);
}