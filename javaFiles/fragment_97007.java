@BeforeMethod
public void nameBefore(Method method)
{
    // You can define any condition on which you want to skip your tests.
    if(method.getName().matches("disabled")){
        throw new SkipException("Skipping test method");
    }       
}