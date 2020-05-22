@Test
public void assertTmParamResultEquals(TmParamResult tmParamResultActual,TmParamResult tmParamResultExpected){
  assertEquals( 
  tmParamResultExpected.get(TagmanConstants.COUNTRY),
  tmParamResultActual.get(TagmanConstants.COUNTRY)
  ....
 )