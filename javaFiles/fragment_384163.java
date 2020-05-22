XmlSerializerProvider provider = new XmlSerializerProvider(new XmlRootNameLookup());
provider.setNullValueSerializer(new NullSerializer());

XmlMapper xmlMapper = new XmlMapper();
xmlMapper.setSerializerProvider(provider);

System.out.println(xmlMapper.writeValueAsString(new Entity()));