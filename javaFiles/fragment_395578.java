public void testDumpWriter() {
    Map<String, Object> data = new HashMap<String, Object>();
    data.put("NAME1", "Raj");
    data.put("NAME2", "Kumar");

    DumperOptions options = new DumperOptions();
    options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
    Yaml yaml = new Yaml(options);
    FileWriter writer = new FileWriter("/path/to/file.yaml");
    yaml.dump(data, writer);
}