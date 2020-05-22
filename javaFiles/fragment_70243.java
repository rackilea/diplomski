public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub
String textToSelect = "headlines today";

WebDriver driver = new FirefoxDriver();
driver.get("https://www.google.co.in/");
Thread.sleep(2000);
WebElement autoOptions= driver.findElement(By.id("lst-ib"));
autoOptions.sendKeys("he");

List<WebElement> optionsToSelect = driver.findElements(By.xpath("//div[@class='sbqs_c']"));

for(WebElement option : optionsToSelect){
    System.out.println(option);
    if(option.getText().equals(textToSelect)) {
        System.out.println("Trying to select: "+textToSelect);
        option.click();
        break;
    }
}