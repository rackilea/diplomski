public class MyClassTest {
  MyInterface mockMyInterface;
  MyClass myClass;

  @Before
  public void setUp() throws Exception {
      mockMyInterface = createMock(MyInterface.class);
  }

  @Test
  public void test() {
    expect(mockMyInterface.validator(10, "Test")).andStubReturn(true);
    replay(mockMyInterface);

    myClass = new MyClass(10, "Test", mockMyInterface);    

    assertEquals(myClass.test, 10);
    verify(mockMyInterface);
  }
}