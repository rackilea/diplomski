public ObservableList<Customer> findAll() {
    ObservableList<Customer> customers = FXCollections.observableArrayList();

    try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL)){

        ResultSet resultSet = statement.executeQuery();
        int i =0;
        while(resultSet.next()){

            // This line moved inside the loop, to create a new
            // object on each iteration:
            Customer customer = new Customer();

            customer.setCustomerId(resultSet.getInt("customerId"));
            customer.setCustomerName(resultSet.getString("customerName"));
            customer.setAddressId(resultSet.getInt("addressId"));
            customer.setActive(resultSet.getInt("active"));
            customer.setCreateDate(resultSet.getTimestamp("createDate"));
            customer.setLastUpdate(resultSet.getTimestamp("lastUpdate"));
            customer.setCreatedBy(resultSet.getString("createdBy"));
            customer.setLastUpdateBy(resultSet.getString("lastUpdateBy"));

            customers.add(customer);
            System.out.println(customers.get(i).getCustomerName());
            i++;
        }

    }catch(SQLException e){
        e.printStackTrace();
        throw new RuntimeException(e);
    }

    return customers;
}