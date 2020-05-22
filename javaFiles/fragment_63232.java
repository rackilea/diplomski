@Override
public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();

    if (source.getClass() == JMenuItem.class) {
        String menuText = ((JMenuItem) evt.getSource()).getText();

        if (menuText.equals("info")) {
            System.out.println("it works");
            JOptionPane.showMessageDialog(null, "aha it works");
        }
    }
    else if (source == one) {
        answerBox.append("1");
    }