String nextLineOut = lines.remove(0);
System.out.println(nextLineOut);
try
{
    //get amount of characters in the next line multiply by 50 to get a pause of x milliseconds per line
    Thread.sleep(nextLineOut.length() * 50);
}
catch (InterruptedException ie)
{//handle errors
}