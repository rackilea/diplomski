if (tally.equalsIgnoreCase("z"))
{
    System.out.println(i++);
    continue running;
}
else if (tally.equalsIgnoreCase("x"))
{
    System.out.println(i--);
    continue running;
}

if (i<=0 || i>=10)
{
    System.out.println("Cant go no more");
    ticking = false;
}