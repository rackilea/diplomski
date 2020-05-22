import javax.swing.JOptionPane;

public class TestDialog {

    public static void main(String[] args) {

    int resp = JOptionPane.showConfirmDialog(null, "A", "B", JOptionPane.YES_NO_OPTION);        
    if (resp == 0)
     System.out.println("call methodA()");
    else
        System.out.println("call foo()");


    }
}