public void jsClick(String cssSelector){
JavascriptExecutor js = (JavascriptExecutor) driver;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("var x = $(\'"+cssSelector+"\');");
        stringBuilder.append("x.click();");
        js.executeScript(stringBuilder.toString());
}