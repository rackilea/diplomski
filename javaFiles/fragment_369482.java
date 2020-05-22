List<WebElement> id_elements = driver.findElements(By.xpath("//table[@id='tblRenewalsStatus']//tr"));

    ArrayList<String> tr_id= new ArrayList<String>();
    for(WebElement ele : id_elements)
     {

        String style = ele.getAttribute("style");

        if(style==null||style=="")
        {
            String id=ele.getAttribute("id");
            tr_id.add(id);
        }
      }

    System.out.println(tr_id);