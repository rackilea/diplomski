List<Customer> customers = new ArrayList<>();
String sql = "SELECT c.id AS cust_id" +
                  ", c.name AS cust_name" +
                  ", c.dob AS cust_dob" +
                  ", p.id AS pet_id" +
                  ", p.name AS pet_name" +
              " FROM Customer c" +
              " LEFT JOIN Pet p ON p.owner_id = c.id" +
             " WHERE c.name LIKE ?" +
             " ORDER BY c.id";
try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    stmt.setString(1, "%DOE%");
    try (ResultSet rs = stmt.executeQuery()) {
        Customer customer = null;
        while (rs.next()) {
            long cust_id = rs.getLong("cust_id");
            if (customer == null || customer.getId() != cust_id) {
                customer = new Customer();
                customer.setId(cust_id);
                customer.setName(rs.getString("cust_name"));
                customer.setDob(rs.getDate("cust_dob"));
                customers.add(customer);
            }
            long pet_id = rs.getLong("pet_id");
            if (pet_id != 0) {
                Pet pet = new Pet();
                pet.setId(pet_id);
                pet.setName(rs.getString("pet_name"));
                pet.setOwner(customer);
                customer.addPet(pet);
            }
        }
    }
}