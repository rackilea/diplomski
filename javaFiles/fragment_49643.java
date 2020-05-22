Semaphore sem = new Semaphore(0);
    client = CuratorFrameworkFactory.builder()
                                 .connectString(connectionString)
                                 .retryPolicy(new ExponentialBackoffRetry(zkConnectionTimeoutMs, 3))
                                 .sessionTimeoutMs(zkSessionTimeoutMs)
                                 .build();
        client.start();

        cache = new TreeCache(client, rootPath);
                    cache.start();

        TreeCacheListener listener = new TreeCacheListener() {

                                    @Override
                                    public void childEvent(CuratorFramework client, TreeCacheEvent event)
                                            throws Exception {
                                        switch (event.getType()) {
                                        case INITIALIZED: {

                                          sem.release();

                                        }

                                    }

                                };
        cache.getListenable().addListener(listener);
       sem.acquire();
child = cache.getCurrentData(rootPath);