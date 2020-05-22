try{
selenium.open("/confluence/login.action?logout=true");
}
catch(Exception e)
{
//Code to write data to a file goes here
System.out.println("Selenium open did not work")
}