public void getList_ByID(String id_element, int list_index_to_click) {
    try {
        WebElement web_el = driver.findElement(By.id(id_element));
        Select select = new Select(web_el);
        List<WebElement> option = select.getOptions();
        option.get(list_index_to_click).getText();
    } catch (Exception e) {
        //errors
    }
}