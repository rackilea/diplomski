Injector injector

@Before {
    injector = Guice.createInjector(new AnotherThingModule());
}

@Test
public void testAnotherThingInstantiated() {
    //act
    AnotherThing another = injector.getInstance(AnotherThing.class);

    //assert
    assertNotNull(another);
}