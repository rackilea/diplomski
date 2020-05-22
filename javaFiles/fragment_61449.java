public List<String> ddgetOpt(WebElement a) {
    Select drp = new Select (a);
    List<WebElement> opt = drp.getOptions();
    List<String> texts = new ArrayList<>();
    for (WebElement we : opt) {
        texts.add(we.getText());
    }
    return texts;
}