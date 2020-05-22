@DataProvider
public static Object[][] provideEnumasAndExpectedErrorResult() {
  return new Object[][] {
    { AnEnum.A, true },
    { AnEnum.B, false }
  };
}

@Test
@UseDataProvider( "provideEnumasAndExpectedErrorResult" )
public void testEnumErrors( AnEnum enumConstant, boolean expectedResult expectedResult ) {
  assertThat( enumConstant.isError(), is(expectedResult));