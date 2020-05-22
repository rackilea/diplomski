//partial css search with "*"
By regExCss = By.cssSelector("[ng-style*='background-image']");

List<WebElement> children = driver.findElements(regExCss);  
// And if you want to print every child(possibly some attribute)
// do a loop

int count = children.size();

for(int i= 0; i<count; i++){
    System.out.print(children.get(i).getAttribute("Class") + "\n");
}