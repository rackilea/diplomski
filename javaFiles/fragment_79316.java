@Test()
public final void login() 
{
   //code
}

@Test(dependsOnMethods={"login"})
public final void flightFinder() 
{
    //code
}