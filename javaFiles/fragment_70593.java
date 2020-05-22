@Test
public void myTest(@Injectable SomeClass dummy)
{
    new ObjectWithUnusedDependency(dummy).doSomething();

    new FullVerifications(dummy) {};
}