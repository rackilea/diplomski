public static double[] getRainFall()
{
    double[] rainfallMonths = new double[12];
    double[] rainfall = new double[12];

    for(int x = 0; x < rainfallMonths.length; x++)
    {
        double input = 0;
        System.out.print("What is the rainfall for month #" + (x + 1) + ": ");
        do {
            rainfallMonths[x] = keyboard.nextDouble();
            rainfall[x] = rainfallMonths[x];
            if(input < 0)
            {
                System.out.println("Input is Invalid");
            }
        } while (rainfallMonths[x] < 0);    
    }


    for(int count = 0; count < rainfallMonths.length; count++)
    {
        System.out.println("Rainfall Month #" + (count + 1) + ": " + rainfall[count]);
    }

    return rainfall;
}