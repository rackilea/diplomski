sql = "select nom from adherent where id_adherent=3";

try {
    pst = con.prepareStatement(sql);
    ResultSet rs = pst.executeQuery();

    if (rs.next()) {
        String sum = rs.getString("nom");
        nom.setText(" " + sum);
    }  
}
catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "here 1");
}