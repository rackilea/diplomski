driver.findElement(By.xpath("")).click();

Set s=driver.getWindowHandles(); //this method will gives you the handles of all opened windows

Iterator ite=s.iterator();

while(ite.hasNext())
{
    String popupHandle=ite.next().toString();
    if(!popupHandle.contains(mwh))
    {
        driver.switchTo().window(popupHandle);
        /**/here you can perform operation in pop-up window**
        //After finished your operation in pop-up just select the main window again
        driver.switchTo().window(mwh);
    }
}