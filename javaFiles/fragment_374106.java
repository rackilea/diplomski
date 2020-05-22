int count =1;
String clink=null;
List<WebElement> rhrev = wd.findElements(By.xpath(".//*[@class='mws-stat-value']"));           
int size=rhrev.size();

for(WebElement e : rhrev) 
{
    clink=e.getText();
    System.out.println(clink);

    if(count<=13)
    {
        Reporter.log("<td>"+clink+ "</td>");
        count++;
    }
    else
    {

        count=1;
        clink=e.getText();
        Reporter.log(" </tr>");
        Reporter.log(" <tr>"); 
        Reporter.log("<td>"+clink+ "</td>");
        count++;
    }
}