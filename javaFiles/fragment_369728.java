double[] valuesArray = new double[] {1.0,2,3,4.5,5.6,6,7,8,9,10};

    double mean = 0;
    double variance = 0;
    double deviation = 0;

    for (int index = 0; index < valuesArray.length ; index ++) {
        mean += valuesArray[index];

        System.out.println("value "+ index + " is : "+valuesArray[index]);
    }

    System.out.println("Sum : "+mean);

    // divide sum by number of values
    mean = mean / ((double) valuesArray.length);

    System.out.println("Mean : "+mean);