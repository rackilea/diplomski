import java.awt.Component;
  import java.awt.Dimension;
  import java.awt.event.ActionEvent;

  import javax.swing.Box;
  import javax.swing.BoxLayout;
  import javax.swing.JButton;
  import javax.swing.JFrame;
  import javax.swing.JLabel;
  import javax.swing.JOptionPane;
  import javax.swing.JPanel;
  import javax.swing.SwingUtilities;

  public class SimpleFrameTest extends JFrame {

  JLabel username = new JLabel("Press button to enter your name here");

   public SimpleFrameTest() {

        setSize(300, 300);
        setTitle("Test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        initComponents();

        setVisible(true);

    }

    private void initComponents() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        username.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton setNameButton = new JButton("Set name");
        setNameButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        setNameButton.addActionListener((ActionEvent e) -> {
             String usernameinput = JOptionPane.showInputDialog(setNameButton, "Enter a username", "Set username", JOptionPane.OK_CANCEL_OPTION);

             if (usernameinput != null) {
                 username.setText(String.valueOf(usernameinput));
             }
        });

        panel.add(Box.createRigidArea(new Dimension(5,10)));
        panel.add(username);
        panel.add(Box.createRigidArea(new Dimension(5,10)));
        panel.add(setNameButton);
        add(panel);

    }


    public static void main(String args[]){

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleFrameTest();

        }
    });   

   }  

 }