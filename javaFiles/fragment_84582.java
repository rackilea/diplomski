@Test
public void someTest() {
   XYZServiceImpl sut = new XYZServiceImpl() {
       public XYZMapper getXYZMapper() {
           return mapperMock;
       }
       public Whatever fetchSet1Details() {
           return whateverYouNeedInTest;
       }
   }

   sut.invokeMethodUnderTest();
}