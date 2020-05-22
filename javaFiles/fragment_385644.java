public interface Foo {
    int getValue();
    String bar(String s);
}

static final class FooImpl implements Foo {
    private final int value;
    FooImpl(int value) { this.value = value; }
    public int getValue() { return value; }
    public String bar(String s) { return s; }
}

@Test
public void dynamicallyMockingAllInstancesOfAClass()
{
    final Foo exampleOfFoo = new FooImpl(0);

    new NonStrictExpectations(FooImpl.class) {{
        exampleOfFoo.bar("test"); result = "aBcc";
    }};

    Foo newFoo = new FooImpl(123);
    assertEquals(123, newFoo.getValue());
    assertEquals("aBcc", newFoo.bar("test")); // mocked
    assertEquals("real one", newFoo.bar("real one")); // not mocked
}