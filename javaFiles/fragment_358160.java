objectMapper.writerWithType(new TypeReference<List<Base>>() {})
 .writeValueAsString(someList);




{
  "@type" : "ConcreteA",
  ...
  }
on deserialization it will be:



objectMapper.registerSubtypes(
        new NamedType(ConcreteA.class, "ConcreteA"),
        new NamedType(ConcreteB.class, "ConcreteB"),
        new NamedType(ConcreteC.class, "ConcreteC")
        );



objectMapper.readValue(....)