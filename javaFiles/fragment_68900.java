import javax.swing.JOptionPane;

public class TestDialog {
    public static void main(String[] args) {
       int cake =  JOptionPane.showConfirmDialog(null,
             "Do you want Cake?", "Cake", JOptionPane.YES_NO_OPTION);

       if (cake == JOptionPane.YES_OPTION) {
           System.out.println("I Like Cake, Yes");
       } else if (cake == JOptionPane.NO_OPTION) {
           System.out.println("I dont like cake, no");
       }
    }
}