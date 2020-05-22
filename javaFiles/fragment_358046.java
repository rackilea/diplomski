import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.*;
public class MyLogin {
   private static void createAndShowGUI() {
      MainGui mainGui = new MainGui();

      JFrame mainFrame = new JFrame("Main GUI");
      mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      mainFrame.add(mainGui);
      mainFrame.pack();
      mainFrame.setLocationRelativeTo(null);

      LoginDialogPanel dialogPanel = new LoginDialogPanel();

      LoginType loginType = null;

      while (loginType == null) {
         int result = JOptionPane.showConfirmDialog(mainFrame, dialogPanel, "Login",
                     JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

         if (result != JOptionPane.OK_OPTION) {
            // JOptionPane to make sure they want to exit
            // exit
            return;
         }

         loginType = dialogPanel.getLoginType();

      }

      System.out.println(loginType.getName());

      // TODO: check login credentials via database in background thread
      // I'd use a SwingWorker and add a PropertyChangeListener to it.
      // In the prop chng listener, if the worker's state is SwingWorker.StateValue.DONE  
      // I'd show the mainFrame GUI if the credentials are OK

      System.out.println("User name: " + dialogPanel.getUserName());
      System.out.print("Never do this, never change a password to String: ");

      // TODO: delete the line of code below
      System.out.println("Password: " + new String(dialogPanel.getPassword())); // ***** !!

      mainGui.setLoginType(loginType);
      mainGui.setUser(dialogPanel.getUserName());

      mainFrame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
}

// parts of my main GUI

@SuppressWarnings("serial")
class MainGui extends JPanel {

   private LoginType loginType;
   private JButton showForAllTypesButton = new JButton("Show for all");
   private JButton showForAdminButton = new JButton("Show for admin");
   private JTextField userField = new JTextField(10);

   public MainGui() {
      userField.setEditable(false);
      userField.setFocusable(false);

      add(new JLabel("User:"));
      add(userField);
      add(Box.createHorizontalStrut(15));
      add(showForAllTypesButton);
      add(showForAdminButton);
   }

   public void setLoginType(LoginType loginType) {
      this.loginType = loginType;
      showForAdminButton.setVisible(loginType == LoginType.ADMINISTRATOR);
      revalidate();
      repaint();
   }

   public void setUser(String user) {
      userField.setText(user);
   }

   public LoginType getLoginType() {
      return loginType;
   }

}

// parts of my login dialog jpanel

class LoginDialogPanel extends JPanel {
   private static final String TITLE = "Login Type";
   private boolean loginSuccessful = false;

   private ButtonGroup loginTypeBtnGroup = new ButtonGroup();
   private JTextField userNameField = new JTextField(10);
   private JPasswordField passwordField = new JPasswordField(10);

   public LoginDialogPanel() {
      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
      JLabel titleLabel = new JLabel(TITLE, SwingConstants.CENTER);
      titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 32));
      JPanel titlePanel = new JPanel();
      titlePanel.add(titleLabel);
      add(titlePanel);

      JPanel radioWrapperPanel = getLoginTypePanel();
      add(radioWrapperPanel);
      add(getNamePasswordPanel());
   }

   private JPanel getLoginTypePanel() {
      JPanel radioBtnPanel = new JPanel(new GridLayout(0, 1));
      for (LoginType loginType : LoginType.values()) {
         JRadioButton radioBtn = new JRadioButton(loginType.getName());
         radioBtn.setActionCommand(loginType.toString());
         loginTypeBtnGroup.add(radioBtn);
         radioBtnPanel.add(radioBtn);
      }
      JPanel radioWrapperPanel = new JPanel();
      radioWrapperPanel.add(radioBtnPanel);
      radioWrapperPanel.setBorder(BorderFactory.createTitledBorder("Login Type"));
      return radioWrapperPanel;
   }

   private JPanel getNamePasswordPanel() {
      JPanel namePasswordPanel = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.insets = new Insets(5, 5, 5, 5);
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.anchor = GridBagConstraints.EAST;
      gbc.fill = GridBagConstraints.BOTH;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      namePasswordPanel.add(new JLabel("User Name:", SwingConstants.TRAILING), gbc);

      gbc.gridy = 1;
      namePasswordPanel.add(new JLabel("Password:", SwingConstants.TRAILING), gbc);

      gbc.gridx = 1;
      gbc.gridy = 0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      namePasswordPanel.add(userNameField, gbc);

      gbc.gridy = 1;
      namePasswordPanel.add(passwordField, gbc);

      JPanel namePasswordWrapperPanel = new JPanel();
      namePasswordWrapperPanel.add(namePasswordPanel);
      namePasswordPanel.setBorder(BorderFactory.createTitledBorder("Login Credentials"));
      return namePasswordPanel;
   }

   public boolean isLoginSuccessful() {
      return loginSuccessful;
   }

   public LoginType getLoginType() {
      ButtonModel model = loginTypeBtnGroup.getSelection();
      if (model == null) {
         return null; // nothing selected
      }

      return LoginType.valueOf(LoginType.class, model.getActionCommand());
   }

   public String getUserName() {
      return userNameField.getText();
   }

   public char[] getPassword() {
      return passwordField.getPassword();
   }

}

enum LoginType {
   STUDENT("Student"), ADMINISTRATOR("Administrator");
   private String name;

   private LoginType(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

}