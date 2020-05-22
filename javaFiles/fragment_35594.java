final By SCRIPT = By.tagName("script");

List<WebElement> scripts = new WebDriverWait(driver, 5)
        .until(ExpectedConditions.presenceOfAllElementsLocatedBy(SCRIPT));

JavascriptExecutor js = (JavascriptExecutor) driver;
String query = "return document.getElementsByTagName(\"script\")[arguments[0]].innerHTML;";     
Pattern p = Pattern.compile("canvas.strokeText\\('Answer: \\d+'");
Pattern p2 = Pattern.compile("\\d+");

String number = IntStream.range(0, scripts.size())
        .mapToObj(i -> (String)js.executeScript(query, i))
        .map(string -> p.matcher(string))
        .filter(m -> m.find())
        .map(m -> p2.matcher(m.group()))
        .filter(m -> m.find())
        .map(m -> m.group())
        .findFirst()
        .orElse(null);
System.out.println(number);  // prints the number rendered on the page