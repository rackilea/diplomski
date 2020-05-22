List<String> productName = new ArrayList<String>();


for(int i=6; i<=27; i=i+3)
{

    List<WebElement> allProductsName = driver.findElements(By.xpath(".//*[@id='result']/div[1]/div["+i+"]"));
    for(WebElement w : allProductsName) {
        productName.add(w.getText());
    }
}
System.out.print(productName);