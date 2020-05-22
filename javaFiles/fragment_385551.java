String elem_css_selector="blablabla...";
 JavascriptExecutor js = (JavascriptExecutor) driver;
        StringBuilder stringBuilder = new StringBuilder();

stringBuilder.append("var x = $(\""+elem_css_selector+"\");");
        stringBuilder.append("return x.text().toString();")       ;


       String resultingText= (String) js.executeScript(stringBuilder.toString());
       Assert.assertTrue(resultingText.trim().equals("Expected Text")   );