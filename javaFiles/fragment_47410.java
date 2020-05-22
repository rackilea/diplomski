@Test // note the "mock parameter" below (or declare a mock field)
public void regularTest(@Mocked final IAmAnInterface mock)
{
    // Record expectations if/as needed:
    new NonStrictExpectations() {{
        mock.someMethod(); result = 123;
    }};

    // Use the mock object in the SUT.
    ...

    // Verify expectations if/as needed:
    new Verifications() {{ mock.doSomething(); }};
}

@Test // this is the equivalent to a Mockito "spy"
public void testUsingPartialMocking()
{
   final IAmAnInterface realObject = new SomeImplementation();

   new NonStrictExpectations(realObject) {{
      // Record zero or more expectations.
      // Calls to "realObject" *not* recorded here will execute real code.
   }};

   // call the SUT

   // verify expectations, if any
}