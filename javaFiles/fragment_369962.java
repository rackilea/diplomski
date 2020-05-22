boolean isXXX=false;
if(custAcctArray != null)
{
    for(int index=0;index<custAcctArray.length;index++)
    {
        if(custAcctArray[i].getCountry().equalsIgnoreCase("XXX"))
        {
            isXXX=true;
            break;//<-------------you need to exit to be quick and true solution!!!!
        }
}
}

if(isXXX)
{
Do something about it....
}