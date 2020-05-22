Random rand = new Random();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter a number");
    //create an array with the size entered by the user
    double[] array = new double[scanner.nextInt()];
    //populate the array with doubles
    for(int i =0; i < array.length; i++) {
        array[i] = rand.nextDouble();
    }