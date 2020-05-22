public class CartFrame extends javax.swing.JFrame {

 public CartFrame() {     
   initComponents();
   List<String> list = GuestFrame.getList();
   cText.setText(list.toString());
   jLabel3.setText(list.toString());
 }
}