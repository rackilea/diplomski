int finalNum = 0;

if (operator.equals("sum"))
{
   finalNum = (x + y);
}
else if (operator.equals("difference"))
{
   finalNum = (x - y);
}   
else if (operator.equals("product"))
{
   finalNum = (x * y);
}
else if (operator.equals("remainder"))
{
   finalNum = (x % y);
}

System.out.print ("The " + operator + " of your two integers is " + finalNum + ".");