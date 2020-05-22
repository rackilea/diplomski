String name = jTextField1.getText();
    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(testJFrame.class.getName()).log(Level.SEVERE, null, ex);
    }

    try {
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=test", "sa", "oraclee");
        String url = "INSERT INTO imageTable (name,photo) VALUES (?,?)";
        PreparedStatement ps = conn.prepareStatement(url);
        ps.setString(1, name);
        ps.setBytes(2, personImage);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "saved");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "n't saved");
    }