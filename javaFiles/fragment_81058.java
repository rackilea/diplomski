public void actionPerformed(ActionEvent e) //When a button is clicked
{
    if (e.getSource() == encrBtn) {
        menu.setVisible(false);
        try {
            createProfile();
        } catch (Exception exp) {
            exp.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to create profile", "Error", JOptionPane.ERROR_MESSAGE);
        }
        menu.setVisible(true);
    } else {
        //...
    }
}