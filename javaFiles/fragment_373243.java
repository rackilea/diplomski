@Test
public void testSingletonAnotherThingNotInstantiatedTwiceByInjector() {
    //act
    AnotherThing first = injector.getInstance(AnotherThing.class);
    AnotherThing second = injector.getInstance(AnotherThing.class);

    //assert
    assertSame(first, second);
}