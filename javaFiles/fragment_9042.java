@AfterMethod
public void afterMethod(ITestResult result)
{

    String tcName = result.getName();
    if(result.getStatus() == ITestResult.SUCCESS)
    {

        //Do something here
        LOG.debug(tcName  + " has passed");
    }

    else if(result.getStatus() == ITestResult.FAILURE)
    {
         //Do something here
        LOG.debug(tcName  + " has failed");

    }

     else if(result.getStatus() == ITestResult.SKIP ){

       LOG.debug(tcName  + " has skipped");
    }
}