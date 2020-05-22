try {
    statement = connection.createStatement();
    String query = "UPDATE customer " + "SET id = " + customer.getCustomerId() + "SET name = " + customer.getName() + "SET tagNo = " + customer.getTagNo() + 
            "SET telephoneNo = " + customer.getTelephoneNo() + "SET email = " + customer.getEmail() + "SET noOfTimesRecycles = " + 
            customer.getNoOfTimesRecycled();

    System.out.println("Update query is:::"+query);
    statement.executeUpdate(query);


} catch (SQLException ex) {
    System.out.println("Error in updating customer");
    ex.printStackTrace();
}

return customer;