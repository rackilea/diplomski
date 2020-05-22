// Let Orika create instance of B
A source = new A();
BoundMapperFacade<A, B> mapper = mapperFactory.getMapperFacade(A.class, B.class);
B target = mapper.map(source);

// Create instance of B yourself and let Orika fill it
A source = new A();
B target = new B();
BoundMapperFacade<A, B> mapper = mapperFactory.getMapperFacade(A.class, B.class);
mapper.map(source, target);