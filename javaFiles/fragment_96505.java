import java.awt.Color;     // no static import needed
   import java.awt.GridBagConstraints;
   import java.awt.GridBagLayout;
   import java.awt.Insets;

   import javax.swing.JButton;
   import javax.swing.JFrame;
   import javax.swing.JPanel;
   import javax.swing.SwingUtilities;

   public class JFrameTest extends JFrame {

       public JFrameTest() {

       setSize(800,800);
       setTitle("Hello :D");
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       setResizable(true);

       initComponents();  // <- Include your components in the main frame

       setVisible(true);

  }

  private void initComponents() {

      // Use meaningful names for your variables
      // Respect Java naming conventions. No variable name start with a capital letter.         
      JPanel panel = new JPanel();
      panel.setBackground(Color.BLACK);    
      panel.setOpaque(true);
      panel.setLayout(new GridBagLayout()); // no need for static access

      JButton button = new JButton();

      GridBagConstraints gbc = new GridBagConstraints(); // this is not a Layout. It represents constrains to be used in the GribBagLayout on adding an element
      gbc.ipadx = 100;
      gbc.ipady = 100;
      gbc.gridheight = 1;
      gbc.gridwidth = 1;
      gbc.weightx = 1;
      gbc.weighty = 1;
      gbc.insets = (new Insets(0,0,0,500));

      panel.add(button, gbc);
      add(panel);   // <- this.add(panel) where this is your instance of JFrameTest

   }


 public static void main(String args[]){

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JFrameTest();
        }
    });   

 }  
}