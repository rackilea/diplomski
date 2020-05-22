public class CustomersResponse extends BasePaginatedResponse {

    private final List<Customer> customers;

    public CustomersResponse(int item_count, int items_per_page, int offset, List<Customer> customers) {
        super(item_count, items_per_page, offset);
        this.customers = customers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public class Customer {
        private final String id, name;

        public Customer(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}