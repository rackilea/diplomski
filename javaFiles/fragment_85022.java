CuratorFramework curator =
    CuratorFrameworkFactory
        .newClient(zkConnectionString, 10000, 10000, retryPolicy);

curator.start();
curator.getZookeeperClient().blockUntilConnectedOrTimedOut();