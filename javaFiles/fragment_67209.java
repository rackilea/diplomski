public static void main(String[] args) {
    try {
            aeroflotCard.authenticity(1);
            System.out.println("\nRefill your balance:");
            aeroflotCard.add(sc.nextInt());
            aeroflotCard.balance(); 
    } catch (yourException e) {
            System.err.println(e.getMessage());
    }
}