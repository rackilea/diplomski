class Customer {
    private String printSequence = null;
    private String indication = null;
    // ... more fields

    // probably don't want this part of the class interface
    private Customer() {}

    static Customer parseFromRecord(String recordLine) {
        // splits the string while removing extra whitespace
        String[] fields = recordLine.split("\\s*\\|\\s*");
        if(fields.length != 408) {
            throw new IllegalArgumentException("Customer record '" + recordLine + "' is invalid.");
        }

        Customer c = new Customer();
        c.printSequence = fields[0];
        c.indication = fields[1];
        // ... for each field

        return cust;
    }
}