final NodesStatsResponse response = client.admin().cluster().prepareNodesStats().setThreadPool(true).execute().actionGet();
    final NodeStats[] nodeStats2 = response.getNodes();

    for (NodeStats nodeStats3 : nodeStats2) {
        ThreadPoolStats stats = nodeStats3.getThreadPool();

        if (stats != null)
            for (ThreadPoolStats.Stats threadPoolStat : stats) {
                System.out.println("node `" + nodeStats3.getNode().getName() + "`" + " has pool `" + threadPoolStat.getName() + "` with current queue size " + threadPoolStat.getQueue());
            }
    }