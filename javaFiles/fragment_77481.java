String lotto[]= request.getParameterValues("lotto");
if(lotto != null)
{
    for(int i=0; i<lotto.length; i++)
    {
        out.print(lotto[i]);
    }
}