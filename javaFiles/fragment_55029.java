import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ShowMeTheImage {

    public static void main(String[] args) {
        new ShowMeTheImage();
    }

    public ShowMeTheImage() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                String text = "<html><img src='" + getClass().getResource("/images/battle.jpg").toString() + "'/>";

                JOptionPane.showMessageDialog(null, text);
            }
        });
    }

}