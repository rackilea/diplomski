public static void displayAvailableSuits(ArrayList<Suit> suits) {
        for (Suit suit : suits) {
            if (suit.getAvailability()) {
                System.out.println(suit.toString());
            }
        }
    }