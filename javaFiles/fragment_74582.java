public void testWithFullInstantiationHelper() throws Exception {
    String baseName = getBaseName();
    ODB odb = open(baseName);

    ClassWithUUID o = new ClassWithUUID("t1", UUID.randomUUID());
    odb.store(o);
    odb.close();
    odb = open(baseName);

    // Sets the instantiation helper
    ClassRepresentation uuidRepresentation = odb.getClassRepresentation(UUID.class);
    uuidRepresentation.addFullInstantiationHelper(new FullInstantiationHelper() {
        public Object instantiate(NonNativeObjectInfo nnoi) {
            // retrieve uuid instance field values 
            AbstractObjectInfo[] aois = nnoi.getAttributeValues();
            // build the instance from the internal values
            return new UUID((Long) aois[0].getObject(), (Long) aois[1].getObject());
        }
    });

    Objects<ClassWithUUID> objects = odb.getObjects(ClassWithUUID.class);
    assertEquals(1, objects.size());
    // check name and uuid
    assertEquals(objects.getFirst().getName(), o.getName());
    assertEquals(objects.getFirst().getUuid(), o.getUuid());
    odb.close();
    deleteBase(baseName);
}