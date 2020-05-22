public class MyClassTest {
    @Test
    public void testThatProcessingMessagesCorrectly() {
        MyObject object = mock(MyObject.class);
        MyObjectFactory factory = mock(MyObjectFactory.class);
        when(factory.createMyObject()).thenReturn(object);
        MyObjectMessager messager = mock(MyObjectMessager.class);

        MyClass processor = new MyClass(factory, messager);
        processor.process();

        verify(factory).createMyObject();
        verify(messager).message(EXPECTED_MESSAGE_1);
        verify(messager).message(EXPECTED_MESSAGE_2);
        ...
        verify(messager).message(EXPECTED_MESSAGE_N);
    }

    ...
}