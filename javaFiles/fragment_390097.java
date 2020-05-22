import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public class Test extends JFrame {

    public static void main(String[] args) {
        new Test();
    }


    private static class searchStud extends JPanel {
        searchStud() {
            add(new JLabel("SEARCH STUD"));
        }
    }


    private Test() {
        SwingUtilities.invokeLater(this::initGUI);
    }

    private void initGUI() {
        JButton button = new JButton("Search");
        button.addActionListener(this::searchStudMenuItemActionPerformed);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(button);
        setSize(300, 200);
        validate();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void searchStudMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        searchStud s = new searchStud();
        s.setVisible(true);
        changePanel(s);
    }                                                  

    private void changePanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();
    }
}