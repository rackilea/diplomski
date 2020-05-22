import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class JExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                int action = JOptionPane.showConfirmDialog(null,
                        "Click Something, Moron!",
                        "Y U NO Click!",
                        JOptionPane.YES_NO_CANCEL_OPTION);
                if(action == JOptionPane.YES_OPTION){
                    System.out.println("YES!");
                }else if(action == JOptionPane.NO_OPTION){
                    System.out.println("NO!");
                }else{
                    System.out.println("CANCEL!");
                }
            }
        });
    }
}