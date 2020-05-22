ClassAliasingMapper statsMapper = new ClassAliasingMapper(xstream.getMapper());
mapper.addClassAlias("somethingAnother", String.class);
xstream.registerLocalConverter(
    InteractionSession.class,
    "stats",
    new CollectionConverter(mapper)
    );