final String PATH = "http://hello.com/api/customers"
WebTarget target = client.target(PATH);
Customer customer = target.path("1234").request().get(Customer.class);
// where 1234 is the id (or in your case `name` of the customer.
// I would avoid using the name as the DB id, that's why my example uses numbers
customer.setPostalCode(...);
target = client.target(PATH).path(customer.getName()); // getName should be 1234
Response response = target.request().put(Entity.xml(customer));