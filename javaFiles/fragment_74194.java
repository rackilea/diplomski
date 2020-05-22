JFrame frame = new JFrame();
    JOptionPane optionPane = new JOptionPane();
    optionPane.setMessage("I got an icon and a text label");
    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
    Icon icon = new ImageIcon("yourFile.gif");
    JButton jButton = getButton(optionPane, "OK", icon);
    optionPane.setOptions(new Object[] { jButton });
    JDialog dialog = optionPane.createDialog(frame, "Icon/Text Button");
    dialog.setVisible(true);

  }

  public static JButton getButton(final JOptionPane optionPane, String text, Icon icon) {
    final JButton button = new JButton(text, icon);
    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        // Return current text label, instead of argument to method
        optionPane.setValue(button.getText());
        System.out.println(button.getText());
      }
    };
    button.addActionListener(actionListener);
    return button;
  }