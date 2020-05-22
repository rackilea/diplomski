@Test
public void myTest(){
    List<String> expectedList = new ArrayList<>();
    MyClass mc = mock(MyClass.class);
    when(mc.getMulti((String[]) anyVararg())).thenReturn(expectedList);
    assertSame(expectedList, mc.getMulti(""));
}