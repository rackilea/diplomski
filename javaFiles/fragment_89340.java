@DataProvider
public Object[][] createDataProviderForTestingVariousApprovalCodes(){
   return new Object[][]{
      { new PaymentRQ("00"), "true"},
      { new PaymentRQ("08"), "true"},
    };
}