class JniUsageTest{

  @Rule 
  public MockitoRule mockitoRule = MockitoJUnit.rule(); 

  @Mock
  private JniInterfaceClass jni;

  @Test
  public void testJniCommunication_SomethingToWrite_PassedToInterface(){
    // arrange
    doReturn("the Answer from JNI").when(jni).calledByCut(any(Object.class));
    YorClassUnderTest cut = new YorClassUnderTest(jni);

    // act
    String resultContainingJniReturn =  cut.doSomethingExpectedToWtiteToJni();

    // assert
    verify(jni,times(10)).calledByCut(any(Object.class));
    assertThat(resultContainingJniReturn, containsString("the Answer from JNI"));
  }

}