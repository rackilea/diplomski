MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

ClassMapBuilder<Foo, Bar> map = mapperFactory.classMap(Foo.class, Bar.class);

Type<Foo> fooType = map.getAType();
Type<Bar> barType = map.getBType()

boolean exists = mapperFactory.existsRegisteredMapper(fooType, barType, false);