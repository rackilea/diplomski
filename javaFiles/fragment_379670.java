private void jButton_NetwerkenActionPerformed(java.awt.event.ActionEvent evt) {                                                  
    try {
            bedrijf.addSubnet(netwerkNaam, netwerkAdres, subnetmask);
    } catch(IllegalArgumentException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Fout: " + e.getMessage(), "Error!", JOptionPane.PLAIN_MESSAGE);
    }
    this.refreshScreen();
}