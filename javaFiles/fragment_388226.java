@Test
public void verifyConfig() {
//verify some test config parameters
}

@Test(dependsOnMethods={"verifyConfig"})
public void dotest(){
//Actual test
}