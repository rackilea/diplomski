Reporter.log("<!DOCTYPE html>");
Reporter.log("<html> <head> <style> table, th, td { border: 1px solid black; border-collapse: collapse; }");
Reporter.log("th, td { padding: 5px; text-align: left; }");
Reporter.log("</style> </head>");
Reporter.log("<body> <table> <tr>");
Reporter.log("<th>Ad Rev.</th> <th>Lead Rev.</th> <th>Booking Rev.</th> <th>Homeaway Rev.</th> <th>VRBO Rev.</th>");
Reporter.log("<th>Hotels.com Rev.</th> <th>Airbnb Rev.</th> <th>Total Projected Rev.</th> <th>Ad Spend</th> <th>G.Profit</th> <th>G.Margin</th> <th>Ad Rev/Spend</th> <th>ROAS</th>");
Reporter.log(" <tr>");      
List<WebElement> rhrev = wd.findElements(By.xpath(".//*[@class='mws-stat-value']"));           
int count =1;
String clink=null;
for(WebElement e : rhrev)
{
    if(count<=13)
    {
        clink=e.getText();
        System.out.println(clink);
        Reporter.log("<td>"+clink+ "</td>");
        count++;
    }
    else
    {
        count=1;
        clink=e.getText();
        Reporter.log(" </tr> <tr>");
        Reporter.log("<td>"+clink+ "</td>");
        count++;                      
    }                 
}
Reporter.log(" </tr> </table> </body> </html>");