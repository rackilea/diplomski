public void actionPerformed(ActionEvent e) {
        String userInput = userText.getText();
        char[] pass = passText.getPassword();
        String p = new String(pass);

        if(e.getSource().equals(loginBtn)) {

            if (userInput.equals(username) && p.equals(password)) {

                jPanel.setVisible(true);
                welcome.setVisible(true);
                jPanel.setBackground(Color.green);
                JOptionPane.showMessageDialog(null, "Correct");
                shopBtn.setVisible(true);
                JButton hiddenBtn = (JButton) e.getSource();
            }

            else {
                jPanel.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Wrong Login Details");
            }
        }

        else if (e.getSource().equals(shopBtn)) {

            SelectionForm selection = new SelectionForm();
            selection.select();

        }
}