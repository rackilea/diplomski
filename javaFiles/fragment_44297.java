List<HierarchicalConfiguration> nodes = config.configurationsAt("attrs/attr");
for(HierarchicalConfiguration c : nodes ) {
    ConfigurationNode node = c.getRootNode();
    System.out.println(
        "name:" + ((ConfigurationNode) 
                            node.getAttributes("name").get(0)).getValue() +
        " VAL:" + ((ConfigurationNode) 
                            node.getAttributes("val").get(0)).getValue());
}