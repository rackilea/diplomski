driver.get("http://www.nyrp.com/");
   WebElement ParentElement= driver.findElement(By.className("schedule")); 

      List<WebElement> schedule= ParentElement.findElements
                           (By.xpath("//img[@alt='Schedule an appointment']"));
                    System.out.println(schedule.size());

                    for(int i=0;i<schedule.size();i++)
                             {
                                schedule.get(i).click();
                                Thread.sleep(5000);
                         }