public class FooTest {

class Foo {

}

private Foo f1 = new Foo();
private Foo f2 = new Foo();

/**
 * Simply checks that both f1/f2 are instances are of the same class
 */
@Test
public void isInstanceOf() throws Exception {
    assertThat(f1, is(instanceOf(Foo.class)));
    assertThat(f2, is(instanceOf(Foo.class)));
}

@Test
public void notSameInstance() throws Exception {
    assertThat(f2, not(sameInstance(f1)));
}

@Test
public void isSameInstance() throws Exception {
    Foo f3 = f1;
    assertThat(f3, is(sameInstance(f1)));
}
}