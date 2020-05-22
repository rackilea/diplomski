Map<Long, Customer> customersById = new HashMap<Long, Customer>();
...
public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
    Invoice invoice = ...
    // populate invoice fields
    Long customerId = rs.getLong("customerId");
    Customer c = customersById.get(customerId);
    if (c == null) {
        // first time we meet this customer
        c = ...
        // populate customer fields from result set
        customersById.put(customerId, c);
    }
    invoice.setCustomer(c);
}