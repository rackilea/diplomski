final int NMAX = 6;
    final double XMAX = 10;

    for(int n = 1; n <= NMAX; n++)
    {
        System.out.printf("%10d", n);
    }
    System.out.println();
    for(int n = 1; n <= NMAX; n++)
    {
        System.out.printf("%10s", "x ");
    }
    System.out.println();
    int counter = 0;
    for(double x = 1; x <= XMAX; x++)
    {
        for (int n = 1; n <= NMAX; n++)
        {
            if(n == 6){
                System.out.printf("%10d",counter);
                counter = 0;
            }else{
                System.out.printf("%10.0f", Math.pow(x, n));
                counter += Math.pow(x, n);

            }
        }
        System.out.println();
    }