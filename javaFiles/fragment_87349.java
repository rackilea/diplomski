public class OrderItem {
    String product_name;
    int product_total;

public OrderItem(String product_name, int product_total) {
        this.product_name = product_name;
        this.product_total = product_total;
    }

      public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public int getProduct_total() {
            return product_total;
        }

        public void setProduct_total(int product_total) {
            this.product_total = product_total;
        }
    }