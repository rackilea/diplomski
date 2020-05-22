String dd;
for(int i = 1; i <= counti; ++i)
{
    for(int j = 1; i <= countj; ++i)
    {
       dd= driver.findElement(By.xpath("//*[@id='listagemConvenios']/table/tbody/tr["+i+"]/td["+j+"]")).getText()   ;
    }
}