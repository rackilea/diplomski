@Test
public void test() throws Exception {
    Bar bar = new Bar("name").update(new Bar[2]);
    Bar barMock = EasyMock.createMock(Bar.class);
    EasyMock.expect(barMock.update(EasyMock.aryEq(new Bar[2]))).andReturn(bar);
    EasyMock.replay(barMock);

    Bar newBar = Foo.internalMethod(barMock);

    EasyMock.verify(barMock);
    assertEquals("name", newBar.name);
    assertNull(newBar.barList[0]);
    assertNull(newBar.barList[1]);
}