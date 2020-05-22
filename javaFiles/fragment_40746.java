int n=in.nextInt();

    int dashes=0;

    for(int i=1;i<=n;i++)
    {
        for(int j=1; j<=dashes;j++)
            System.out.print("-");

        for(int k=1;k<=n-i+1;k++)
            System.out.print(k);

        // for next row - starts in new line
        System.out.println();
        dashes++;
    }