List<Customer> customers = new ArrayList<Customer>();
ResultSet rs = stmt.executeQuery("SELECT * from CUSTOMER;");
while (rs.next()) {
  Customer customer = new Customer();
  customer.setFirstName(rs.get("First_Name"));
  // ... and so on

  customers.add(customer);
}