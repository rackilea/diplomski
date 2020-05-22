List<Customer> customers = new ArrayList<Customer>();

String customerName = nameField.getSelectedText();
String address = addressField.getSelectedText(); 
Customer customer = new Customer();
customer.setName(customerName); 
customer.setAddress(address);
customers.add(customer);