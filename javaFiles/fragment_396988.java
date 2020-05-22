String propertiesFile = FileUtils.readFileToString(file, "utf-8");
String[] propertyDivs = propertiesFile.split("----");
ArrayList<Properties> properties = new ArrayList<Properties>();

for (String propertyDiv : propertyDivs) {
     properties.add(new Properties().load(new StringReader(propertyDiv)));
}