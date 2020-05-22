public class firstclass {
    private static WebDriver driver= new FirefoxDriver();

    @DataProvider(name="readcredentials")
    public Object[][] readcredentials() throws Exception{

        CSVReader readunamepass= new CSVReader(new FileReader("D:/My Projects New/DSP/Aut/Credentials.csv"));
        List<String[]> list = readunamepass.readAll();
        String[][] array = new String[list.size()][];
        for(int i=0;i<list.size();i++)
        {
            array[i] = list.get(i);
        }
        return array;
    }

    @Test(priority=0, dataProvider="readcredentials")
    public void f1(String value, String value1) throws Exception {
        System.out.println(value+" "+value1);
        getDriver().get("http://192.168.1.128/lms");
        getDriver().findElement(By.id("txtUserId")).sendKeys(value);
        getDriver().findElement(By.id("txtPwd")).sendKeys(value1);
        getDriver().findElement(By.id("btnSign")).click();

        //to do
        //your logic
    }



  public WebDriver getDriver(){

  return driver;


 }




}