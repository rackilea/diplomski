public class ProductsResponse extends BasePaginatedResponse {

    private final List<Customer> products;

    public ProductsResponse(int item_count, int items_per_page, int offset, List<Customer> products) {
        super(item_count, items_per_page, offset);
        this.products = products;
    }

    public List<Customer> getProducts() {
        return products;
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