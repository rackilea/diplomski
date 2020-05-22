private Foo foo;

@Before 
public void setUp() {
 foo = new Foo();
}

@Test(expected = IndexOutOfBoundsException.class)
public void noArgsShouldFail() {
 foo.doStuff();
}

@Test(expected = NullPointerException.class)
public void nullArgShouldFail() {
 foo.doStuff(null);
}

@Test(expected = MyOwnException.class)
public void nullAndEmptyStringShouldFail() {
 foo.doStuff(null,"");
}

@Test(expected = DomainException.class)
public void doOtherStuffShouldFail() {
 foo.doOtherStuff();
}