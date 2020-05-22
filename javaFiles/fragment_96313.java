Scanner input = new Scanner(System.in);
    System.out.println("How many days do you need the rental?");
    int rentalLength = input.nextInt();
    input.nextLine(); // ADD this line
    System.out.println("Enter requested car size:" +
            "\nEconomy" + "\nMidsize" + "\nFullsize" + "\nLuxury");
    String rentalCarSize = input.nextLine();
    input.next();