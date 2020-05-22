File fileContents = new File("currencyFile.txt");


    if(!fileContents.exists()) {
        System.out.println("File doesn't exist ");
    }
    else{
        Scanner inputFile = new Scanner(fileContents);
        while(inputFile.hasNextDouble())
        {
            double result;
            double conversionRate = 0.78;
            double currencyFrom = inputFile.nextDouble();
            result = currencyFrom  * conversionRate;
            System.out.println("£" + currencyFrom + " = " + "€" + result);
        }
        inputFile.close();

    }