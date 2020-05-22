@Test
public void doSomethingHandlesSomeCheckedException() throws Exception
{
  new Expectations() {
     DependencyAbc abc;

     {
        new DependencyAbc(); // expect constructor

        abc.intReturningMethod(); result = 3;

        abc.stringReturningMethod();
        returns("str1", "str2");
        result = new SomeCheckedException();
     }
  };

  new UnitUnderTest().doSomething();
}