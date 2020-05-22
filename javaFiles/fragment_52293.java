List <WebElements> optionsInnerText= driver.findElements(By.tagName("option"));

     for(WebElement text: optionsInnerText){

    String textContent = text.getAttribute("textContent");

    if(textContent.toLowerCase.contains(expectedText.toLowerCase))

           select.selectByPartOfVisibleText(expectedText);
    }