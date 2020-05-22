Properties props = new Properties();
props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

AdminClient adminClient = AdminClient.create(props);

ConfigResource resource = new ConfigResource(ConfigResource.Type.TOPIC, "test");

// get the current topic configuration
DescribeConfigsResult describeConfigsResult  =
        adminClient.describeConfigs(Collections.singleton(resource));

Map<ConfigResource, Config> config = describeConfigsResult.all().get();

System.out.println(config);

// create a new entry for updating the retention.ms value on the same topic
ConfigEntry retentionEntry = new ConfigEntry(TopicConfig.RETENTION_MS_CONFIG, "50000");
Map<ConfigResource, Config> updateConfig = new HashMap<ConfigResource, Config>();
updateConfig.put(resource, new Config(Collections.singleton(retentionEntry)));

AlterConfigsResult alterConfigsResult = adminClient.alterConfigs(updateConfig);
alterConfigsResult.all();

describeConfigsResult  = adminClient.describeConfigs(Collections.singleton(resource));

config = describeConfigsResult.all().get();

System.out.println(config);

adminClient.close();