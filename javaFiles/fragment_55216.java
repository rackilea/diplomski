//ABC.class
@Test (priority=2)
public void method_name()
{
    //Initialize page objects
    XYZ xyz = PageFactory.initElements(driver, XYZ.class);

    //Call the method
    xyz.my_method();
}