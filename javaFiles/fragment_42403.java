Settings.Builder settings = Settings.builder()
.put("path.home", ".")
.put("discovery.zen.ping.unicast.hosts","192.168.1.1");

Node node = NodeBuilder.nodeBuilder().settings(settings)
      .clusterName("elasticsearch")
      .client(true)
      .node();