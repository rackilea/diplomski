while(search_pages.size() != 0) {
    List<WebElement> job_desc=driver.findElements(By.xpath("//div[contains(@id,'p')][contains(@class,'row')]"));
    for(WebElement e: job_desc){
        String str_job_description=e.getText();
        if(!((str_job_description.contains("Automation")) || (str_job_description.contains("Amazon"))) ){
            System.out.println(str_job_description);
        }
    }
    driver.findElement(By.xpath("//span[contains(@class,'np')][contains(text(),'Next')]")).click(); 
}