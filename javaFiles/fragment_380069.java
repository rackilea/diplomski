class Test { 
  private String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
  @Rule
  public final MethodRule mockito = MockitoJunit.rule(); 

  @Spy
  private File theFile = new File("data\\test\\" + timeStamp );

  @Mock
  private File theParent;

  @Before
  public void setup(){
     doReturn(theParent).when(theFile).getParentFile();
  }
  @Test
  void testWriteReadObjectFileNotFound() {
    // arrange
    doReturn(Boolean.FALSE).when(theFile).exists();
    String s1 = "testObj";
    // act
    wr.writeObject(s1, theFile);  
    // assert
    verify(theParent).mkdirs();
    verify.(theFile).createNewFile();
 }
}