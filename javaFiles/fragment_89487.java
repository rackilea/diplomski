int answer = JOptionPane.showConfirmDialog(null,full_name+"\n"+number_age+"\n"+gender+"\n"+address+
                 "\n"+birthday+"\n"+cell_no,"CHECK INFORMATION!",JOptionPane.YES_NO_OPTION);
if (JOptionPane.YES_OPTION == answer)) {
    JOptionPane.showMessageDialog(null,"Thank you for Entering");
} else {
    JOptionPane.showMessageDialog(null,"Please Retry");
}