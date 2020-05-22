String zkHost = "localhost:9983";
    TEMP_DIR = Files.createTempDirectory("MiniSolrCloudCluster");

    JettyConfig.Builder jettyConfig = JettyConfig.builder();
    jettyConfig.waitForLoadingCoresToFinish(null);

    cluster = new MiniSolrCloudCluster(1, TEMP_DIR, jettyConfig.build());
    cloudSolrClient = cluster.getSolrClient();