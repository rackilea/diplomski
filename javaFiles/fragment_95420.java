import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SwingTest extends JFrame {

    private final JPanel  userUpdatePanel;
    private final JComboBox<Integer> memberSelection;

    public SwingTest()  {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        memberSelection = new JComboBox<>(new Integer[]{1,2,3,4,19,26});
        memberSelection.addActionListener(e-> memberSelectionActionPerformed());
        add(memberSelection, BorderLayout.PAGE_START);
        userUpdatePanel = new JPanel();
        add(userUpdatePanel);
        pack();
        setVisible(true);
    }

     private void memberSelectionActionPerformed(){
         int numBerOfPanels = (int) memberSelection.getSelectedItem();
         userUpdatePanel.removeAll();
         userUpdatePanel.setLayout(new GridLayout(0,2));
         for(int i =0; i < numBerOfPanels; i++){
              userUpdatePanel.add(new JTextField());
         }
         pack();
     }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new SwingTest());
    }
}