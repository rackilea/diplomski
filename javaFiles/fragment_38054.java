Configuration configuration = new PropertiesConfiguration(filename);
Iterator<String> keys = configuration.getKeys();
List<String> keyList = new ArrayList<String>();
while(keys.hasNext()) {
    keyList.add(keys.next());
}