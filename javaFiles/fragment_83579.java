public boolean checklogin(String name, String Pass) throws Exception {
        boolean check = false;

        String sql = "SELECT * FROM admin WHERE name =? and password= ?";
        DatabaseConnection db = new DatabaseConnection();
        Connection conn = db.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, Pass);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            check = true;
            Interface_Perfil ip = new Interface_Perfil();
            System.out.println("dddd");
            ip.txtExibirNomePerfil.setText(rs.getString("name"));
            ip.txtExibirNickPerfil.setText(rs.getString("password"));
            ip.txtExibirSenha.setText("Senha");
            ip.txtExibirEmailPerfil.setText("email@hotmail.com");
            ip.setVisible(true);
        }
        ps.close();
        rs.close();
        conn.close();
        return check;
    }