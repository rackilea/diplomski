public void writeAllProperties(HashMap<String, String> newProps)
        throws IOException {
    // fileOut = new BufferedWriter(new FileWriter(config));
    HashMap<String, String> props = loadAllProperties();
    props.putAll(newProps);
    config.delete();
    config.createNewFile();
    config.setWritable(true);
    try (BufferedWriter fileOut = new BufferedWriter(new FileWriter(config))) {
        System.out.println(config.canWrite());
        for (Entry<String, String> entry : props.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
            fileOut.write(String.format("%1$s=%2$s", entry.getKey(),
                    entry.getValue()));
        }
    }
}