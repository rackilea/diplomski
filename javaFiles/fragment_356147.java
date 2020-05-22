public class MyConverter implements Converter {

    public boolean canConvert(Class clazz) {
        return AbstractMap.class.isAssignableFrom(clazz);
    }

    @Override
    public void marshal(Object arg0, HierarchicalStreamWriter writer, MarshallingContext context) {}

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {

        Map<String, String> map = new HashMap<String, String>();
        reader.moveDown();  // Get down to the firstTag and secondTag level.

        while(reader.hasMoreChildren()) {
            if(reader.getNodeName().equals("firstTag")) {
                while(reader.hasMoreChildren()) {
                    reader.moveDown();
                    String key = reader.getAttribute("key");
                    String value = reader.getAttribute("value");
                    map.put(key, value);
                    reader.moveUp();
                }
            }
        }
        return map;
    }
}