public class ClientData {

    private static final AtomicReference<Map<String, Map<Integer, String>>> primaryMapping = new AtomicReference<>();
    private static final CountDownLatch firstSet = new CountDownLatch(1);

    public static Map<String, Map<Integer, String>> getPrimaryMapping() {

        try { firstSet.await(); } catch (Exception ignored) {}
        return primaryMapping.get();
    }

    public static void setPrimaryMapping(Map<String, Map<Integer, String>> map) {

        primaryMapping.set(map);
        firstSet.countDown();
    }
}