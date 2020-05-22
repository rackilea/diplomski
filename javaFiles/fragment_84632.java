ObjectMapper mapper = new ObjectMapper();

CollectionType propertiesListType = mapper.getTypeFactory().constructCollectionType(List.class, Property.class);
SimpleModule module = new SimpleModule();
module.addSerializer(new PropertyListJSONSerializer(propertiesListType));
mapper.registerModule(module);