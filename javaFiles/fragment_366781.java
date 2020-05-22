// We do not want the first two contents as they represent default or error case. 
List<WebElement> tr_collection=table_element.findElements(By.xpath("//tbody//tr[position()>2]"));

int i=1;
for(WebElement trElement : tr_collection)
{
    List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
    int j=1;
    for(WebElement tdElement : td_collection)
    {
        String check = tdElement.getText();
        String header = driver.findElement(By.xpath("//tbody//tr/th[" + j + "]")).getAttribute("class");

        if(header.equals("data-Name")) {
            if(isValidName(check))
                passed("Name Test : " );
            else{
                log(check + " is not a valid name");
            }
        }
        if(header.equals("data-Email")) {
            if(isValidEmail(check))
            {   passed("Email address Test : ");

            }
            else
                log(check + " is not a valid email"); 
        }
        //... and so on

     }
  }