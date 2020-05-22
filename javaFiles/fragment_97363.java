if (driver.getPageSource().contains("Team"))
{
     WebElement elem = driver.findElement(By.partialLinkText("Team"));      
     //Check if the element's type is a link
     if (elem.getTagName().equals("a"){
          elem.click();
     }
     return;
}