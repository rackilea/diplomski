XStream xstream = new XStream();
xstream.alias("root", java.util.Map.class);
xstream.registerConverter(new MyConverter());

String xml = ...
Map<String, String> map = (Map<String, String>) xstream.fromXML(xml);