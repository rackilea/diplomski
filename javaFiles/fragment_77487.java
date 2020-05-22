import java.awt.*;
import javax.swing.*;

public class InGameMenu extends JPanel {

   private static final String[] EXAMPLE_TEXT = {"One", "Two", "Three"};
   private static final int COLUMNS = 40;
   private static final int ROWS = 20;
   private JTextArea chatBox;
   private JPanel buttonPanel;
   private TextField chatTextField;
   private JList playersList;
   private DefaultListModel listModel;
   // private ConnectionToServer conn;
   private JFrame mainFrame;

   // public InGameMenu (ConnectionToServer conn, JFrame mainFrame)
   public InGameMenu(JFrame mainFrame) {

      this.setBackground(Color.CYAN);
      // this.conn = conn;
      this.mainFrame = mainFrame;
      mainFrame.setTitle("Game menu");
      super.setLayout(new GridBagLayout());
      // chatBox = new JTextArea("This is player's chat.\n");
      chatBox = new JTextArea("This is player's chat.\n", ROWS, COLUMNS);

      GridBagConstraints gbc = new GridBagConstraints();

      // chat box
      // gbc.gridheight = 10;
      // gbc.gridwidth = 10;
      gbc.fill = GridBagConstraints.BOTH;
      gbc.gridx = 0;
      gbc.gridy = 0;
      // this.add(chatBox, gbc);
      chatBox.setWrapStyleWord(true);
      chatBox.setLineWrap(true);
      JScrollPane scrollPane = new JScrollPane(chatBox);
      this.add(scrollPane, gbc);


      // chat text field
      chatTextField = new TextField("dsadasda", COLUMNS);
      chatTextField.setBackground(Color.GRAY);
      // gbc.gridheight = 1;
      gbc.gridy = 1;
      this.add(chatTextField, gbc);

      // lista graczy
      listModel = new DefaultListModel();
      for (int i = 0; i < EXAMPLE_TEXT.length; i++) {
         listModel.addElement(EXAMPLE_TEXT[i]);
      }
      playersList = new JList(listModel);
      playersList.setPrototypeCellValue(String.format("%40s", " "));

      // gbc.gridheight = 15;
      // gbc.gridwidth = 4;
      gbc.gridx = 1;
      gbc.gridy = 0;
      this.add(playersList, gbc);

      // panel przyciskow
      buttonPanel = new JPanel(new FlowLayout());
      // gbc.gridheight = 1;
      gbc.gridy = 1;
      this.add(buttonPanel, gbc);

   }

   public InGameMenu() {
      // TODO Auto-generated constructor stub
   }

   private static void createAndShowGui() {

      JFrame frame = new JFrame("In Game Menu");
      InGameMenu mainPanel = new InGameMenu(frame);
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}