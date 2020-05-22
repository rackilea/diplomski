@override
  protected void setUp() {
     subClass = new SubClass(mockContext)
 }

  public testCase() { 
    assertEquals(subClass.line == "hello world");