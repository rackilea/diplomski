public MyEpicAbstractClassTest {
    public void testThatNeedsTheFakeMessageWriter() {
        ShuntedMyEpicAbstractClass meac = new ShuntedMyEpicAbstractClass();

        meac.doSomething("Arguments");

        verify(meac.getMessageWriter()).write("Arguments");
    }
}

// And the shunt is here
public class ShuntedMyEpicAbstractClass extends MyEpicAbstractClass {
    private IMessageWriter stubbedWriter = Mockito.mock(IMessageWriter.class);

    public IMessageWriter getMessageWriter() {
       return stubbedWriter;
    }
}