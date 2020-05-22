import java.awt.EventQueue;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                Menu menu = new Menu();
                JOptionPane.showMessageDialog(null, menu, "PlayerName", JOptionPane.PLAIN_MESSAGE);

                String playerName = menu.getPlayerName();

                // Now you can write it to the file if you need

            }
        });
    }

    public class Menu extends JPanel {

        private JTextField playerName;

        public Menu() {
            setLayout(new GridBagLayout());
            playerName = new JTextField(10);
            add(new JLabel("Player name: "));
            add(playerName);
        }

        public String getPlayerName() {
            return playerName.getText();
        }
    }

}