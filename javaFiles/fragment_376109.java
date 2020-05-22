// Construct a Jackson JavaType for your class
JavaType javaType = mapper.getTypeFactory().constructType(MyDto.class);

// Introspect the given type
BeanDescription beanDescription = mapper.getSerializationConfig().introspect(javaType);

// Find properties
List<BeanPropertyDefinition> properties = beanDescription.findProperties();