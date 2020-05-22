private static final String IP_CLUSTER = "192.168.0.116:5701";

Config cfg = new Config();
// set IP of cluster
cfg.getNetworkConfig().getJoin().getTcpIpConfig().addMember(IP_CLUSTER).setEnabled(true);
cfg.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);    
HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);