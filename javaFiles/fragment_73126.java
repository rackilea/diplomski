private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
    String sql = "UPDATE LibrarySystemDatabase"
                 + " SET txtTitle = ?"
                    + ", txtAuthor = ?"
                    + ", txtGenre = ?"
                    + ", txtLexile = ?"
                    + ", txtPoints = ?"
               + " WHERE txtNo = ?";
    try (PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setString(1, txtTitle.getText());
        pst.setString(2, txtAuthor.getText());
        pst.setString(3, txtGenre.getText());
        pst.setString(4, txtLexile.getText());
        pst.setString(5, txtPoints.getText());
        pst.setString(6, txtNo.getText());
        int count = pst.executeUpdate();
        JOptionPane.showMessageDialog(null, count + " Records Updated");
        updateTable();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}