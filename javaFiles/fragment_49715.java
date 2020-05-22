public List<Customer> findCustomersInArea(int area)
{
    // create a list to store all Customer with given area
    List<Customer> inArea = new ArrayList<Customer>();
    // iterate all entries in customers map
    for (Map.Entry<String, Customer> entry : customers.entrySet())
    {
        // get the customer
        Customer c = entry.getValue();
        if (c.getArea() == area) {
            // do what you need, for example add to a list
            inArea.add(c);
        }
    }
    // return the list with all customers
    return inArea;
}