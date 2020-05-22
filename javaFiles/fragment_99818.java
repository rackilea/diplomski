Select select=new Select(driver.findElement(By.xpath("//div[@id='views/div/select']"));

select.selectByVisibleText("NIC");
or
select.selectByIndex(0);
or
select.selectByValue("value");