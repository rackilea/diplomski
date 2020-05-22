private void verifyConnection(TransportClient client) {
    ImmutableList<DiscoveryNode> nodes = client.connectedNodes();
    if (nodes.isEmpty()) {
        throw new ElasticsearchException(
                "No nodes available. Verify ES is running!");
    } else {
        log.info("connected to nodes: " + nodes.toString());
    }
}