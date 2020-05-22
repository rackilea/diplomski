Scanner input = new Scanner(System.in);
    System.out.println("Enter calorie of food: ");
    int value = 0;
    value = input.nextInt();

    value = deserts.calculateCaloriesLeft(value);
    System.out.println("calories left: " + value);