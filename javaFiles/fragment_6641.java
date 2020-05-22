WebDriverWait wait = new WebDriverWait(driver, 10);
String email = "you@domain.com";
WebElement emailInputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#identify_email")));
JavascriptExecutor executor = (JavascriptExecutor) driver;
executor.executeScript("arguments[0].setAttribute('value', ' " + email + "')", emailInputField);
break;