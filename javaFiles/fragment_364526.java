public static void main(String[] args) {
    // ...
    KE_Globals.dataFile = fileChooser.getSelectedFile().getAbsoluteFile();
    List<Customer> customers = new ArrayList<>();
    Scanner input = new Scanner(KE_Globals.dataFile);
    while (input.hasNextLine()) {
        String customerRecord = input.nextLine();
        customers.add(Customer.parseFromRecord(customerRecord));
    }
}