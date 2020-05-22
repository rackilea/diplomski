import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderProcessor {
    public static void main(String[] args) {
        PriorityQueue<OrderEntity> q = new PriorityQueue<>(new OrderEntityComparator());
        q.add(new OrderEntity(4000, 1));
        q.add(new OrderEntity(5000, 2));
        q.add(new OrderEntity(100, 3));
        q.add(new OrderEntity(50, 4));

        while(!q.isEmpty())
            System.out.println(q.poll());
    }

    public static class OrderEntityComparator implements Comparator<OrderEntity> {

        @Override
        public int compare(OrderEntity o1, OrderEntity o2) {
            if(o1.getId() <= 3000 && o2.getId() <= 3000)
                return Integer.compare(o1.getOrderNo(), o2.getOrderNo());
            if(o1.getId() > 3000 && o2.getId() > 3000)
                return Integer.compare(o1.getOrderNo(), o2.getOrderNo());
            if(o1.getId() <= 3000 && o2.getId() > 3000)
                return -1;
            return 1;
        }
    }

    public static class OrderEntity {
        private int id;
        private int orderNo;

        public OrderEntity(int id, int orderNo) {
            this.id = id;
            this.orderNo = orderNo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(int orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public String toString() {
            return "OrderEntity{" +
                    "id=" + id +
                    ", orderNo=" + orderNo +
                    '}';
        }
    }
}