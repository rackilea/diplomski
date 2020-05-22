@Test(groups={"webtest"})
public void snapshotTest(ITestContext ctx){


    ctx.getCurrentXmlTest().addParameter("param1","param2");
}


@AfterMethod
public void afterMethod(ITestContext ctx){

    System.out.println(ctx.getCurrentXmlTest().getParameter("param1"));

}