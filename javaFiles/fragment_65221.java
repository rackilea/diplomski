CountDownLatch lastLatch = new CountDownLatch(0);

for (int i = 1; i <= 254; i++) {
    ip[3] = (byte) i;
    InetAddress address = null;
    try {
        address = InetAddress.getByAddress(ip);
    } catch (UnknownHostException e) {
        e.printStackTrace();
    }

    CountDownLatch nextLatch = new CountDownLatch(1);

    executor.execute(pingRunnable(address, lastLatch, nextLatch));

    lastLatch = nextLatch;
}