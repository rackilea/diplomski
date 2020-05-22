@Test
public void mockingAnInterface() throws Exception
{
    CallbackHandler callbackHandler = new MockUp<CallbackHandler>() {
        @Mock
         void handle(Callback[] callbacks)
         {
             assertEquals(1, callbacks.length);
             assertTrue(callbacks[0] instanceof NameCallback);
         }
    }.getMockInstance();

    callbackHandler.handle(new Callback[] {new NameCallback("Enter name:")});
}