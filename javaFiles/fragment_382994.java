import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable(){
      @Override public void run() {
        JFrame frm = new JFrame("Text formatting");
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String giraffesays = "<html><span style=\"font-family:Arial;font-size:13px;\">Giraffe says :</span>Hi there!</html>";
        frm.getContentPane().add(new JLabel(giraffesays));
        frm.pack();
        frm.setLocationByPlatform(true);
        frm.setVisible(true);
      }
    });
  }
}