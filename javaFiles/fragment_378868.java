public static void freeCustomer(ArrayList<customer> customers, ArrayList<supplement>supplements) {
    for(int i=0;i<customers.size();i++) {
        customers.set(i, new customer());
        customers.get(i).readInput();
    }
}