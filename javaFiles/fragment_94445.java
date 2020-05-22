String json = "[{\"bark\":\"bowwow\"},{\"bark\":\"woofWoof\"},{\"meow\":\"meeeOwww\"},{\"meow\":\"hisssss\"}]";

UniquePropertyPolymorphicDeserializer<Animal> deserializer = 
    new UniquePropertyPolymorphicDeserializer<>(Animal.class);

deserializer.register("bark", Dog.class); // if "bark" field is present, then it's a Dog
deserializer.register("meow", Cat.class); // if "meow" field is present, then it's a Cat

SimpleModule module = new SimpleModule("UniquePropertyPolymorphicDeserializer", 
        new Version(1, 0, 0, null, "com.example", "polymorphic-deserializer")); 
module.addDeserializer(Animal.class, deserializer);

ObjectMapper mapper = new ObjectMapper();
mapper.registerModule(module);

Animal[] animals = mapper.readValue(json, Animal[].class);