try{
    Class.forName("com.mysql.jdbc.Driver");
    String url="jdbc:mysql://localhost/proiectibd";
    try (Connection conn = DriverManager.getConnection(url, "root", "")) {
        String sql = "select Titlul_cartii,Data_publicatie,Pret from carte,autor where carte.autor_idautor=autor.idAutor and Nume_Autor=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1,cboxAutor.getSelectedItem().toString());
            try (ResultSet rs=ps.executeQuery()) {
                jTable1.setModel(DbUtils.resultSetToTableModel (rs));
            }
        }
    }
} catch(SQLException e){
    e.printStackTrace();// At the very least...
    //JOptionPane.showMessageDialog(null,e);
}