public void testDumpWriter() {
   Map<String, Object> data = new HashMap<String, Object>();
   data.put("name", "Silenthand Olleander");
   data.put("race", "Human");
   data.put("traits", new String[] { "ONE_HAND", "ONE_EYE" });

   Yaml yaml = new Yaml();
   FileWriter writer = new FileWriter("/path/to/file.yaml");
   yaml.dump(data, writer);
}