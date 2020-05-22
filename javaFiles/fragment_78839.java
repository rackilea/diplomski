public class TestClass {
  private TestMachine tester;
  public void setUp() {         
    tester = mock(TestMachine.class);     
  }      

  public void testOne() {
          when(tester.ping(anyString()).thenReturn(-1);
          assertFalse(tester.machineIsGood("testHost"));
     }
}