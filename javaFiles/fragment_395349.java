Browser_Launch("chrome");
    sign_in();
    List<String> a = new ArrayList<>();
    Element_to_be_clicked("xpath", "//*[@id='history-guide-item']/a");
    List<WebElement> text = driver.findElements(By.xpath("//ol[@class='item-section']//li//div//a"));
    for (int i = 0; i < text.size(); i++) {
        a.add(text.get(i).getText());
        System.out.println(text.get(i).getText());
    }        
    if (a.contains("Will & Grace - Back This Fall")) {
        System.out.println("test passed");
    } else {
        System.out.println("test failed");
    }