mapperFactory.classMap(SOURCE.class, DEST.class)
                    .customize(new CustomMapper<SOURCE, DEST>() {
        @Override
        public void mapAtoB(SOURCE source, DEST dest, MappingContext context) {

            //verifies the type to instantiate
            private A2 a2 = isB2() ? new B2() : new B3;             
            //use the mapper for the class (will use the B2 or B3 mapper)
            mapperFacade.map(source.getA2(), a2);
            // set the field into the dest object
            dest.setB1(a2);

        }
}