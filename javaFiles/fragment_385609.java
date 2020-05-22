private void comboboxAPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) { 

    String display = (String) comboboxA.getSelectedItem();
    String sql = "Select authorid from submission where paperid =?";

    comboboxB.removeAllItems(); // <- Clear comboboxB

    try {
        ps = conn.prepareStatement(sql);
        ps.setString(1, display);
        rset = ps.executeQuery();

        while (rset.next()) {  // <- Include all authors found
           String add1 = rset.getString("authorid");
           System.out.println(add1);
           comboboxB.addItem(add1);
        }

   } catch(Exception e) {
        JOptionPane.showMessageDialog(null,e);
   }
}