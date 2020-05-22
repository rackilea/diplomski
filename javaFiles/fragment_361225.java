String query = "select * from server where sid = ? "
             + "OR application = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, textFieldSearchServer.getText());
            pst.setString(2, textFieldSearchServer.getText());
            ResultSet rs = pst.executeQuery();