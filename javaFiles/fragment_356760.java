public class TestDump {
    public static void main(String[] args) {
        LinkedHashMap<String, Object> values = new LinkedHashMap<String, Object>();
        values.put("one", 1);
        values.put("two", 2);
        values.put("three", 3);

        DumperOptions options = new DumperOptions();
        options.setIndent(2);
        options.setPrettyFlow(true);
        // Fix below - additional configuration
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        Yaml output = new Yaml(options);

        File targetYAMLFile = new File("C:\\temp\\sample.yaml");
        FileWriter writer =null;
        try {
            writer = new FileWriter(targetYAMLFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        output.dump(values, writer);
    }
}