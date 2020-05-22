Function<Customer, String> customerToName = new Function<Customer, String>() {
        public String apply(Customer c) {
            return c.getName();
       };

List<String> allCustomerNamesList = Lists.transform(list, customerToName);