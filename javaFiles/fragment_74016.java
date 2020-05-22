Scanner keyboard = new Scanner(System.in);
    double weight;
    double cost = 15.00; // set first pound to $15
    double output = 0;
    System.out.print("Weight?: ");
    weight = keyboard.nextDouble();
    if (weight <= 0) {
        System.out.println("Weight must be a positive number.");
    } else {
        // Print the charge of the package
        if (weight > 1) {
            output = cost + ((weight-1) * 10);
        } else {
            output = cost;
        }
        DecimalFormat money = new DecimalFormat("$0.00");
        System.out.println("Pay: " + money.format(output));
    }