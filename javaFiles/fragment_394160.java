private void Bağlan_ButonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        String user=Uname_Textfield.getText();
        String pwd= new String (Password_PasswordField.getPassword());
        try {  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://192.168.131.10;" + "databaseName=Digitalk;" + "user=" + user + ";" + "password=" + pwd + ";";      
            Connection con = DriverManager.getConnection(connectionUrl);
            new ProgramPenceresi().setVisible(true);
            dispose();
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Kullanıcı Adı veya Şifre Yanlış!");   
        } catch (ClassNotFoundException cE) {
                System.out.println("Class Not Found Exception: "+ cE.toString());
        }
    }