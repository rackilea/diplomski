import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;

public class CustomerList {

  public static void main(String[] args) {
    // Sample data
    Map<Integer, Customer> customers = new HashMap<>();
    customers.put(1, new Customer("Kevin", UUID.randomUUID(), "Cash"));
    customers.put(2, new Customer("Sally", UUID.randomUUID(), "Credit card"));
    customers.put(3, new Customer("Kate", UUID.randomUUID(), "Cash"));

    Vector<ListItem> items = new Vector<>();
    for (Map.Entry<Integer, Customer> entry : customers.entrySet()) {
      items.add(new ListItem(entry.getKey(), entry.getValue()));
    }

    JList list = new JList(items);

    JFrame f = new JFrame("Customer List");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(list, BorderLayout.CENTER);
    f.setBounds(300, 200, 400, 300);
    f.setVisible(true);
  }
}

class ListItem {
  private int classNumber;
  private Customer customer;

  ListItem(int classNumber, Customer customer) {
    this.classNumber = classNumber;
    this.customer = customer;
  }

  @Override
  public String toString() {
    // You can change this to suite the presentation of a list item
    return classNumber + " - " + customer.name + " (" + customer.payMethod + ")";
  }
}

class Customer {

  final String name;
  final String payMethod;
  public final UUID uniqueId;

  public Customer(String name, UUID uniqueId, String payMethod) {
    this.name = name;
    this.uniqueId = uniqueId;
    this.payMethod = payMethod;
  }
}