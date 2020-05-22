public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double distance;
        double mpg;
        double pricePerGallon;
        double milesPerKwh;
        double pricePerKwh;
        double totalCostGas;
        double totalCostElec;
        String type;

        System.out.println("Enter whether the car is 'elec' or 'gas': ");

        type = in.next();
        if (type.equals("elec")) {
            System.out.println("Enter the Total Distance in Miles: ");
            distance = in.nextDouble();
            System.out.println("Enter the total Miles per Kwh: ");
            milesPerKwh = in.nextDouble();
            System.out.println("Enter the Total Price per Kwh: ");
            pricePerKwh = in.nextDouble();
            totalCostElec = (distance / milesPerKwh) * pricePerKwh;
            System.out.printf("The trip is going to cost $%5.2f: ",
                    totalCostElec);

        } else if (type.equals("gas")) {
            System.out.println("Enter the Total Distance in Miles: ");
            distance = in.nextDouble();
            System.out.println("Enter the Miles per Gallon: ");
            mpg = in.nextDouble();
            System.out
                    .println("Enter the total Price per Gallon of Gasoline: ");
            pricePerGallon = in.nextDouble();
            System.out
                    .println("Enter the total Price per Gallon of Gasoline: ");
            pricePerGallon = in.nextDouble();
            totalCostGas = (distance / mpg) * pricePerGallon;
            System.out.printf("The trip is going to cost $%5.2f", totalCostGas);

        } else {
            System.out.println("Please resubmit entry");
        }

        System.out.println();
    }