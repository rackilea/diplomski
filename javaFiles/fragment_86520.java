private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {                                         
    try {

        if(txtIme.getText() == null || "".equals(txtIme.getText())) return;
        if(txtPrezime.getText() == null || "".equals(txtPrezime.getText())) return;
        izraz = veza.prepareStatement("insert into autor (ime,prezime)" + "value (?,?)");


        izraz.setString(1, txtIme.getText());
        izraz.setString(2, txtPrezime.getText());



        if (izraz.executeUpdate()== 0) {
            JOptionPane.showMessageDialog(getRootPane(), "Nothing was changed.");

        } else {
            ucitajIzBaze();
            ocistiPolja();
        }

        izraz.close();

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

}