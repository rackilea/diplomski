waitForElement.until(ExpectedConditions.elementToBeClickable(
                     By.xpath("//td[following-sibling::td[2] = '" + cField + "']/input")));
   //                                     quotes added here ---^  and here ---^
WebElement checkBox =
   driver.findElement(By.xpath("//td[following-sibling::td[2] = '" + cField + "']/input"));
   //                                      quotes added here ---^  and here ---^