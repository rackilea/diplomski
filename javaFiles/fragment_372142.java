import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Demo {

  public static void main(String[] a) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JComboBox jComboBox1 = new JComboBox();
    jComboBox1.addItem("Item 0");
    jComboBox1.addItem("Item 1");
    jComboBox1.addItem("Item 2");
    jComboBox1.addItem("Item 3");
    jComboBox1.addItem("Item 4");
    jComboBox1.addItem("Item 5");

    Object cmboitem = jComboBox1.getSelectedItem();
    System.out.println(cmboitem);

    frame.add(jComboBox1);

    jComboBox1.setSelectedIndex(4);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }
}