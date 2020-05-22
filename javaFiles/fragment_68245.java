// Find the outer element.
WebElement outer = driver.findElement(By.anything("whatever"));

// This doesn't work, it searches the whole page for the XPath expression.
WebElement inner = outer.findElement(By.xpath("//some/nasty/xpath"));

// This works! It takes the outer element as root.
WebElement inner = outer.findElement(By.xpath(".//some/nasty/xpath"));