for(WebElement mylink :del_elements)
{
    mylink.Click();
    // do anything else here to handle deleting the entry

    String linkid= mylink.getAttribute("id");
    Thread.sleep(5000);
     System.out.println("Deleting element:" + linkid);
 }