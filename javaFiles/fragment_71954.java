@DataProvider(name = "drivers")
public provideDrivers(){
   ...create drivers here...
   return new Object[][]{{firefoxDriver},{chromeDriver},....};
}

@Test(dataProvider = "drivers")
public runTest(WebDriver driver){
   ...do stuff with driver here...
}