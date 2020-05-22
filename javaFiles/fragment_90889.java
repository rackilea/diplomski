import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class ADMIN {

  private List<Customer_Data> user;

  public static void main(String[] args) {
    ADMIN admin = new ADMIN();
    admin.user = new ArrayList<>();

    Customer_Data customer1 = new Customer_Data();
    customer1.account_num = 123;
    customer1.name = "Kevin";
    admin.user.add(customer1);

    Customer_Data customer2 = new Customer_Data();
    customer2.account_num = 456;
    customer2.name = "Sally";
    admin.user.add(customer2);

    Customer_Data customer3 = new Customer_Data();
    customer3.account_num = 789;
    customer3.name = "Peter";
    admin.user.add(customer3);

    admin.Search();
  }

  public void Search() {
    String s1 = "", s2 = "";
    s1 = JOptionPane.showInputDialog("Enter Account Number u want to ", s2);
    boolean found = false;
    for (int i = 0; i < user.size(); i++) {
      Customer_Data var = user.get(i);
      if (var.account_num == Integer.parseInt(s1)) {
        JOptionPane.showMessageDialog(null, var.account_num + "\n" + var.name, "sad", JOptionPane.PLAIN_MESSAGE);
        found = true;
      }
    }
    if (!found) {
      JOptionPane.showMessageDialog(null, "Not Fount");
    }
  }
}

class Customer_Data {
  public int account_num,starting_balance=0 ;
  public String pincode="",name="",type="",account_num1="";
  public Object status;
}