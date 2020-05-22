@Test
public void testWrite() {
    MyWriter out = EasyMock.createMock(MyWriter.class);
    EasyMock.expect(mock.println(EasyMock.anyObject())).times(3);
    EasyMock.expect(mock.close()).times(1);

    List<FigureGeneral> list = ...
    list.add(...);
    list.add(...);
    list.add(...);

    replay(mock);

    MyClass myClass = new MyClass();
    myClass.setOut(out);
    myClass.write("mockFileName", list);        

    verify(mock);
}