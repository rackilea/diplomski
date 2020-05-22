public class GuestFrame extends javax.swing.JFrame {
    private static List<String> list = new ArrayList<String>();

    public GuestFrame(){
       initComponents();    

    }

    public static List<String> getList() {
       return list;
    }
 }