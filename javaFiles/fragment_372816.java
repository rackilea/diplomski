try(Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", "elastictest").build();
Client client = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress("1.1.1.1", 9300));) {
//your code
} catch (//your exceptions if any) {
//handle exceptions
}