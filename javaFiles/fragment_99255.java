Runtime.getRuntime().addShutdownHook(new Thread() {
    public void run() {
        log.info("Undeploying " + id);
        CountDownLatch latch = new CountDownLatch(1);
        theClusteredVertxInstance.undeploy(id, h -> {
            if (h.succeeded()) {
                log.info("undeployed.");

            } else {
                log.error(h.cause());
            }
            latch.countDown();
        });
        try {
            latch.await(5, TimeUnit.SECONDS);
        } catch(Exception ignored) {
        }
    }
});