public static Transaction recordTransaction(){

    System.out.println("Enter the customer ID to create the transaction > "); long customerID = scan.nextLong();

    for (Customer c : customers) {
        if (c.getCustomerID() == customerID) {
            Transaction trans = new Transaction();

            System.out.println("\nEnter the weight of gold > ");
            trans.goldWt = scan.nextDouble();

            System.out.println("\nEnter the weight of platinum > ");
            trans.platinumWt = scan.nextDouble();

            System.out.println("\nEnter the weight of silver > ");
            trans.silverWt = scan.nextDouble();

            return trans;
        }
    }
    return null; 
}