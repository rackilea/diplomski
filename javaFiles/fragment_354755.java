loop=true;
    System.out.println("Enter how many numbers to Subtract?");
    n=s.nextInt();
    int sum=0;
    for(i=1;i<=n;)
    {
        try
        {
            System.out.println("Enter number "+i+" : ");
            a=s.nextInt();
            sum=a-sum;
            i++;
        }
        catch(Exception e)
        {
            System.out.println("Invalid Entry. Try again!!");
        }
    }