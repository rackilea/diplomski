class LoginPanel extends JPanel {
  private final JTextField userNameTxtFld;
  private final JPasswordField passwordFld;

  public LoginPanel() {
      super(new GridBagLayout()); // GridBagLayout: Not everyone's bag.

      this.userNameTxtFld = new JTextField(12);
      this.passwordFld = new JPasswordField(12);

      userNameTxtFld.setText(System.getProperty("user.name"));

      GridBagConstraints gbc = new GridBagConstraints();
      gbc.anchor = GridBagConstraints.WEST;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.insets = INSETS;
      gbc.ipadx = 0;
      gbc.ipady = 0;
      gbc.weightx = 0.0;
      gbc.weighty = 0.0;
      gbc.gridx = 0;
      gbc.gridy = 0;

      int row = 0;
      addLabelledComponent("User Name:", userNameTxtFld, this, gbc, 0, row++);
      //noinspection UnusedAssignment
      addLabelledComponent("Password:", passwordFld, this, gbc, 0, row++);
  }

  private boolean gainedFocusBefore;

  void gainedFocus() {
      if (!gainedFocusBefore) {
          gainedFocusBefore = true;
          passwordFld.requestFocusInWindow();
      }
  }

  String getUserName() {
      return userNameTxtFld.getText();
  }

  String getPassword() {
      return new String(passwordFld.getPassword());
  }

  void reset() {
      passwordFld.setText("");
  }

  public static void main(String[] args) {
      final LoginPanel pnl = new LoginPanel();
      JOptionPane op = new JOptionPane(pnl, JOptionPane.PLAIN_MESSAGE,   JOptionPane.OK_CANCEL_OPTION);
      JDialog dlg = op.createDialog("Login");
      dlg.addWindowFocusListener(new WindowFocusListener() {
          @Override
          public void windowGainedFocus(WindowEvent e) {
              pnl.gainedFocus();
          }

          @Override
          public void windowLostFocus(WindowEvent e) {
          }
      });
      dlg.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      dlg.setVisible(true);
      System.exit(0);
  }
}