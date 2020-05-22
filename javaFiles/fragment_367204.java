Select sel = new Select(driver.findElement(By.xpath("//select[@name='Students']")));

    sel.selectByVisibleText("student4");

    List<WebElement> list = sel.getOptions();

    for(int i=0;i<list.size();i++){
        if(list.get(i).getText().equals(sel.getFirstSelectedOption().getText())){
            System.out.println("The index of the selected option is: "+i);
            break;
            }
    }