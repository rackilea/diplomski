ObjectMapper mapper = new ObjectMapper();

SimpleModule module = new SimpleModule("CustomModel", Version.unknownVersion());

SimpleAbstractTypeResolver resolver = new SimpleAbstractTypeResolver();
resolver.addMapping(Interface.class, Implementation.class);

module.setAbstractTypes(resolver);

mapper.registerModule(module);