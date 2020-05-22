public class Table {
WebDriver driver; 

By rowList = By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr/td[2]");

  @Test
  public void f() {
  String expRowValue="$513";

System.setProperty("webdriver.chrome.driver", "C:/Users/dell/Downloads/chromedriver/chromedriver.exe");
driver = new ChromeDriver();
driver.get("http://newtours.demoaut.com/");
driver.manage().window().maximize();

List<WebElement>rowsData =  driver.findElements(rowList);
int k=1;    
for (WebElement rowValue: rowsData) {
    if (rowValue.getText().equals(expRowValue)){
        System.out.println("ROw Index::" + k);
    }
k++;    
}

}
}