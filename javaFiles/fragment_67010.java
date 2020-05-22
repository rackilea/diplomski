JavascriptExecutor js = (JavascriptExecutor)driver;
Object claimNo= js.executeScript("var value = document.evaluate(\"//div[@id='claim-num-success']/b[text()='Claim Number:']/following-sibling::text()[1]\",document, null, XPathResult.STRING_TYPE, null ); return value.stringValue;");
System.out.println("Claim Number : "+ claimNo.toString());

Object Status= js.executeScript("var value = document.evaluate(\"//div[@id='claim-num-success']/b[text()='Status:']/following-sibling::text()[1]\",document, null, XPathResult.STRING_TYPE, null ); return value.stringValue;");
System.out.println("Status : "+ Status.toString());