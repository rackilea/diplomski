public Map<Double, Item> createListOfCompetitors() {
    Map<Double, Item> lanes = new HashMap<>();

    try (Scanner sc = new Scanner(System.in)) {
        do {
            System.out.println("Enter Competing Runner Name");
            String name = sc.nextLine();

            System.out.println("Assign a lane to the runner! ");
            double lane;
            do {
                String lane = sc.nextLine();
                try {
                    lane = Double.parseDouble(lane);
                    if (lanes.get(lane) == null) {
                        lanes.put(lane, new Item(name, lane));
                        break;
                    } else {
                        System.out.println("Lane number already chosen.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid lane number.");
                }
           } while (true);
       } while (sc.nextLine().equalsIgnoreCase("y"));
   }

    return lanes;
}