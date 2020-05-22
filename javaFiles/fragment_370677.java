String cssSelector="abracadabra";    
JavascriptExecutor js = (JavascriptExecutor) driver;        
StringBuilder stringBuilder = new StringBuilder();        
stringBuilder.append("var x = $(\""+cssSelector+"\");");
stringBuilder.append("return x.text().toString();");      
String res= (String) js.executeScript(stringBuilder.toString());
Assert.assertTrue(res.trim().contains("Assigned VDIs")   );