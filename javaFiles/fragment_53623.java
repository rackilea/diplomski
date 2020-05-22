static void FindMultiple()
{
    long lcm=1;
    for(long i=2;i<=20;i++)
    {
        lcm=FindLcm(lcm,i);
    }
    System.out.println("Lcm="+lcm);
}