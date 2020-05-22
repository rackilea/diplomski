service = new Service(); 

// Get default type mapping
TypeMapping tmap = DefaultTypeMappingImpl.getSingletonDelegate();

// Register our custom serializer / deserializer 
tmap.register(
        MyCustomClass.class, 
        MyCustomClassQName, 
        new MyCustomSerizalizerFactory(), 
        new MyCustomDeserizalizerFactory());

// Add it back to the service
service.getTypeMappingRegistry().register(
        "http://schemas.xmlsoap.org/soap/encoding/", // Default encoding
        tmap);