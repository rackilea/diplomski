private static void collectInfo(PetInfo[] info) {
    Scanner input = new Scanner(System.in);
    try {
        for (int i = 0; i < info.length; i++) {
            System.out.print("Enter pet name: ");
            String petName = input.nextLine();
            System.out.print("Enter pet type: ");
            boolean petType = input.nextBoolean();
            input.nextLine();
            System.out.print("Enter pet breed: ");
            String petBreed = input.nextLine();
            System.out.print("Enter pet age: ");
            double petAge = input.nextDouble();
            input.nextLine();
            System.out.print("Enter pet weight: ");
            double petWeight = input.nextDouble();
            input.nextLine();
            System.out.print("Enter pet owner: ");
            String petOwner = input.nextLine();
            info[i] = new PetInfo(petName, petType, petBreed, petAge, petWeight, petOwner);
        }
    }
    finally {
        input.close();
    }
}