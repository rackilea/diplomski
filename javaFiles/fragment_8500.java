@Then    
    public void I_can_see_the_following_fields_in_the_xyz_page(DataTable table) throws Throwable {
        WebElement element;
        List<Map<String, String>> list = table.asMaps(String.class,String.class); 
        for(Map<String, String> list : data) {
            element = driver.findElement(By.xpath(list.get("Locator")));
            Assert.assertTrue("Element : "+list.get("Field Name")+ "not found",isElementPresent(element));   
        }
    }