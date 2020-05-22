XmlMapper xmlMapper = new XmlMapper();
MyObject myObj = xmlMapper.readValue(xml, MyObject.class);

ObjectMapper jsonMapper = new ObjectMapper();
String json = jsonMapper.writeValueAsString(myObj);

System.out.println(json);