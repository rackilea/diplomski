public void testRedis() {
    ScanParams scanParams = new ScanParams().count(1000);
    Set<String> allKeys = new HashSet<>();
    for (JedisPool pool : getRedisCluster().getClusterNodes().values()) {
        String cur = ScanParams.SCAN_POINTER_START;
        do {
            try (Jedis jedis = pool.getResource()) {
                ScanResult<String> scanResult = jedis.scan(cur, scanParams);
                allKeys.addAll(scanResult.getResult());
                cur = scanResult.getStringCursor();
            }
            if (allKeys.size() >= 1000) break;
        } while (!cur.equals(ScanParams.SCAN_POINTER_START));
        if (allKeys.size() >= 1000) break;
    }
    allKeys.stream().forEach(System.out::println);
}